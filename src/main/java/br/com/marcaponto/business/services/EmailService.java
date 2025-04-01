package br.com.marcaponto.business.services;

import br.com.marcaponto.business.converters.EmailConverter;
import br.com.marcaponto.business.dto.out.EmployeeDTOResponse;
import br.com.marcaponto.business.dto.out.TimeEntryDTOResponse;
import br.com.marcaponto.infrastructure.entities.Email;
import br.com.marcaponto.infrastructure.entities.enums.EmailStatus;
import br.com.marcaponto.infrastructure.exceptions.EmailException;
import br.com.marcaponto.infrastructure.repositories.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final EmployeeService employeeService;
    private final EmailConverter emailConverter;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender, TemplateEngine templateEngine, EmployeeService employeeService, EmailConverter emailConverter) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.employeeService = employeeService;
        this.emailConverter = emailConverter;
    }

    @Async
    public void sendEmail(TimeEntryDTOResponse timeEntryDTO, String emailEmployee){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dateTimeFmtd = fmt.format(timeEntryDTO.getMoment().atZone(ZoneId.systemDefault()).toLocalDateTime());
        EmployeeDTOResponse employeeDTO = employeeService.findEmployeeById(timeEntryDTO.getEmployee_id());
        int pos = employeeDTO.getName().indexOf(" ");
        Email email = emailConverter.entityToEmail(timeEntryDTO);

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom("noreply@horadoponto.com");
            mimeMessageHelper.setTo(InternetAddress.parse(emailEmployee));
            mimeMessageHelper.setSubject("Notificação de cadastro de ponto - "+ dateTimeFmtd);

            Context context = new Context();
            context.setVariable("employeeName", employeeDTO.getName().substring(0, pos));
            context.setVariable("date", dateTimeFmtd.substring(0, 10));
            context.setVariable("time", dateTimeFmtd.substring(11));
            String template = templateEngine.process("time-entry-notification", context);
            mimeMessageHelper.setText(template, true);
            javaMailSender.send(message);
            email.setStatus(EmailStatus.SENT);
        } catch (MessagingException e) {
            email.setStatus(EmailStatus.FAILED);
            throw new EmailException("Erro ao enviar o e-mail ", e.getCause());
        } finally {
            saveEmail(email);
        }
    }

    public void saveEmail(Email email){
        emailRepository.save(email);
    }
}