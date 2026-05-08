package com.jcr.prueba.infraestruture.helper.excepcion;

public class BusinessExcepction extends RuntimeException {
    public BusinessExcepction(String message) {
        super(message);
    }
}
