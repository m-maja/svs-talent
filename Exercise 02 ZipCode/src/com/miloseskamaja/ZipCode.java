package com.miloseskamaja;

public class ZipCode {
    private String value;

    public ZipCode(String zipCode) {
        setValue(zipCode);
    }

    public ZipCode() {}

    public void setValue(String value) {
        if ((value.length() == 5 || value.length() == 9) && value.matches("[0-9]+")){
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}
