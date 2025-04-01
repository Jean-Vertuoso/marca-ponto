package br.com.marcaponto.infrastructure.exceptions;

import org.springframework.mail.MailException;

public class MailAuthenticationException extends MailException {

    public MailAuthenticationException(String msg) {
        super(msg);
    }

    public MailAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
