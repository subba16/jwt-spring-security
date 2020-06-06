package com.subba.jwtsecurity.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class AppException {

    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public AppException(String message, HttpStatus httpStatus, ZonedDateTime z) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = z;
    }
}
