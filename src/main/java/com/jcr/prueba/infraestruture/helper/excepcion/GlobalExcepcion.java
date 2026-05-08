package com.jcr.prueba.infraestruture.helper.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExcepcion extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessExcepction.class)
    public ResponseEntity<?> handleBusinessException(BusinessExcepction e) {
        Mensaje mensaje = new Mensaje(e.getMessage());
        return new ResponseEntity<>(mensaje.getMensaje(), HttpStatus.NOT_FOUND);
    }
}
