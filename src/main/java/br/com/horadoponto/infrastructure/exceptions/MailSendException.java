package br.com.horadoponto.infrastructure.exceptions;

import org.springframework.mail.MailException;

public class MailSendException extends MailException {

    public MailSendException(String msg) {
        super(msg);
    }

    public MailSendException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
