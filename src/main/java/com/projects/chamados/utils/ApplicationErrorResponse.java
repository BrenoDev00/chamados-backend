package com.projects.chamados.utils;

import org.springframework.http.HttpStatus;

public class ApplicationErrorResponse {
    private String errorMessage;
    private HttpStatus httpStatus;

    public ApplicationErrorResponse(String errorMessage, HttpStatus httpStatus){
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }

    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }
}
