package br.com.marcaponto.business.converters;

import br.com.marcaponto.business.dto.out.TimeEntryDTOResponse;
import br.com.marcaponto.infrastructure.entities.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailConverter {

    public Email entityToEmail(TimeEntryDTOResponse timeEntryDTO){
        Email email = new Email();
        email.setTimeEntry_id(timeEntryDTO.getId());
        email.setSentAT(timeEntryDTO.getMoment());

        return email;
    }
}
