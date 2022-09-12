package com.mmacedoaraujo.coursespringboot.controllers.exceptions;

import com.mmacedoaraujo.coursespringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
