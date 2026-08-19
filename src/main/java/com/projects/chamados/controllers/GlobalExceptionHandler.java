package com.projects.chamados.controllers;

import com.projects.chamados.exceptions.ApplicationException;
import com.projects.chamados.utils.ApplicationErrorResponse;
import com.projects.chamados.utils.InputValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationErrorResponse> handleException(ApplicationException exception, HttpServletRequest request){
        var applicationErrorResponse = new ApplicationErrorResponse(exception.getMessage(), exception.getHttpStatus());

        return ResponseEntity.status(applicationErrorResponse.getHttpStatus()).body(applicationErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationErrorResponse> handleInternalServerErrorException(Exception exception, HttpServletRequest request){
        var applicationErrorResponse = new ApplicationErrorResponse("Erro interno do servidor. Tente novamente.", HttpStatus.INTERNAL_SERVER_ERROR);

        System.out.println("Erro na aplicação: " + exception.getMessage());

        return ResponseEntity.status(applicationErrorResponse.getHttpStatus()).body(applicationErrorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleInputValidationErrors(MethodArgumentNotValidException exception, HttpServletRequest request){
        var validationErrorsResponse = new InputValidationErrorResponse(exception).getFormattedErrorsResponse();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorsResponse);
    }
}
