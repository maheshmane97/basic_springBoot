package com.hc.udemy.controller;

import com.hc.udemy.exception.ExceptionDetails;
import com.hc.udemy.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDetails> userNotFoundExceptionHandler(Exception ex, WebRequest req){
                ExceptionDetails details=new ExceptionDetails(HttpStatus.NOT_FOUND,ex.getLocalizedMessage(),LocalDate.now());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleExceptions(Exception ex, WebRequest req){
        ExceptionDetails details=new ExceptionDetails(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),LocalDate.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    Map<String, String> handleException(MethodArgumentNotValidException e){
//        Map<String, String> errors=new HashMap<>();
//        e.getBindingResult().getAllErrors().forEach((error)->{
//            String fieldName=((FieldError)error).getField();
//            String message=((FieldError)error).getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return errors;
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ExceptionDetails details=new ExceptionDetails(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),LocalDate.now());
//        return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
//    }
}
