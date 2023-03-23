package com.hc.udemy.exception;

import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;
import java.time.LocalDate;

public class ExceptionDetails {

    private HttpStatus status;
    private String message;
    private LocalDate timeStamp;

    public ExceptionDetails(HttpStatus status, String message, LocalDate timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
}
