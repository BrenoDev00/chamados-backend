package com.projects.chamados.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException{
    private HttpStatus httpStatus;

    public ApplicationException(HttpStatus httpStatus, String errorMessage){
        this.httpStatus = httpStatus;
        super(errorMessage);
    }

    public HttpStatus getHttpStatus(){return this.httpStatus;}
}
