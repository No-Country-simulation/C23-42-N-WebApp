package org.nctry.server.Exceptions;

public class BadRequestException extends RuntimeException {
    //TODO: Crear data de la excepcion y un mensaje coherente
    public BadRequestException(String message) {
        super(message);
    }
}
