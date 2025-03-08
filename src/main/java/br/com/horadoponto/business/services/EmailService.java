package br.com.horadoponto.business.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.horadoponto.business.converters.EmailConverter;
import br.com.horadoponto.business.dto.EmployeeDTO;
import br.com.horadoponto.business.dto.TimeEntryDTO;
import br.com.horadoponto.infrastructure.entities.Email;
import br.com.horadoponto.infrastructure.entities.enums.EmailStatus;
import br.com.horadoponto.infrastructure.exceptions.MailAuthenticationException;
import br.com.horadoponto.infrastructure.exceptions.MailSendException;
import br.com.horadoponto.infrastructure.repositories.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;
    private final EmployeeService employeeService;
    private final EmailConverter emailConverter;

    public EmailService(EmailRepository emailRepository, JavaMailSender mailSender, EmployeeService employeeService, EmailConverter emailConverter) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
        this.employeeService = employeeService;
        this.emailConverter = emailConverter;
    }

    public void sendEmail(TimeEntryDTO timeEntryDTO, String emailEmployee){
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(timeEntryDTO.getEmployee_id());
        Email email = emailConverter.entityToEmail(timeEntryDTO);
        try {
            mailSender.send(emailConverter.emailToMessage(emailEmployee, employeeDTO));
            email.setStatus(EmailStatus.SENT);
        }catch (MailAuthenticationException mailAuthenticationException){
            throw new MailAuthenticationException("Erro na autenticação do e-mail: "+ mailAuthenticationException.getCause());
        }catch (MailSendException mailSendException){
            throw new MailSendException("Erro no envio do e-mail: "+ mailSendException.getCause());
        }finally{
            if(email.getStatus() == null){
                email.setStatus(EmailStatus.FAILED);
            }
            saveEmail(email);
        }
    }

    public void saveEmail(Email email){
        emailRepository.save(email);
    }
}