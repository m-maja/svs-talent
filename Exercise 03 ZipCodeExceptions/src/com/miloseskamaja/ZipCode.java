package com.miloseskamaja;

public class ZipCode {
    private String value;

    public ZipCode(String zipCode) {
        setValue(zipCode);
    }

    public ZipCode() {}

    public void setValue(String value) {
        if (!(value.length() == 5 || value.length() == 9) ){
            throw new WrongZipCodeFormatException("ZipCode must contain 5 or 9 digits");
        } else if (!value.matches("[0-9]+")){
            throw new WrongZipCodeFormatException("ZipCode must contain only digits from 0 to 9");
        } else {
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}
