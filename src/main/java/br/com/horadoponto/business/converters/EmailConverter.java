package br.com.horadoponto.business.converters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import br.com.horadoponto.business.dto.EmployeeDTO;
import br.com.horadoponto.business.dto.TimeEntryDTO;
import br.com.horadoponto.infrastructure.entities.Email;

@Component
public class EmailConverter {

    public SimpleMailMessage emailToMessage(String employeeEmail, EmployeeDTO employeeDTO) {
        LocalDateTime dateTime = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var message = new SimpleMailMessage();
        message.setFrom("noreply@horadoponto.com");
        message.setTo(employeeEmail);
        message.setSubject("Confirmação de Registro de Ponto - " + dateTime.format(fmt));
        message.setText(mountText(dateTime, fmt, employeeDTO));

        return message;
    }

    public Email entityToEmail(TimeEntryDTO timeEntryDTO){
        Email email = new Email();
        email.setTimeEntry_id(timeEntryDTO.getId());
        email.setSentAT(timeEntryDTO.getMoment());

        return email;
    }

    private String mountText(LocalDateTime dateTime, DateTimeFormatter fmt, EmployeeDTO employeeDTO){
        StringBuilder sb = new StringBuilder();
        int pos = employeeDTO.getName().indexOf(" ");
        sb.append("Olá "+ employeeDTO.getName().substring(0, pos) +", \nSeu registro de ponto foi realizado com sucesso! Aqui estão os detalhes:");
        sb.append("\nData: "+ dateTime.format(fmt).substring(0, 10));
        sb.append("\nHorário: "+ dateTime.format(fmt).substring(11));
        sb.append("\nCaso não tenha realizado este registro ou tenha alguma dúvida, entre em contato com o RH.");

        return sb.toString();
    }
}
