package com.projects.chamados.utils;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class InputValidationErrorResponse {
    private MethodArgumentNotValidException exception;

    public InputValidationErrorResponse(MethodArgumentNotValidException exception){
        this.exception = exception;
    }

    public List<String> getFormattedErrorsResponse(){
        return this.exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage()).toList();
    }
}
