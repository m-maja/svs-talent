package com.seavus.exceptions;

public class WrongComandException extends RuntimeException {
    public WrongComandException(String message) {
        super(message);
    }

}
