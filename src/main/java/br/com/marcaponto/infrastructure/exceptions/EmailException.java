package br.com.marcaponto.infrastructure.exceptions;

public class EmailException extends RuntimeException{

    public EmailException(String mensagem){
        super(mensagem);
    }

    public EmailException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }
}
