package com.miloseskamaja;

public class WrongZipCodeFormatException extends RuntimeException {
    public WrongZipCodeFormatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
