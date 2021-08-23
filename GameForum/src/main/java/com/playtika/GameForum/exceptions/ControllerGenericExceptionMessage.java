package com.playtika.GameForum.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerGenericExceptionMessage extends ResponseEntity<String> {
    String message;
    HttpStatus httpErrorCode;

    public ControllerGenericExceptionMessage(String message, HttpStatus httpErrorCode) {
        super(message, httpErrorCode);
        this.message = message;
        this.httpErrorCode = httpErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(HttpStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }
}
