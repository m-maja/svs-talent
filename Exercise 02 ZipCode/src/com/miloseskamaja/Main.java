package com.miloseskamaja;

public class Main {

    public static void main (String [] args){
        ZipCode zipCode = new ZipCode();

        zipCode.setValue("123456789");
        System.out.println(zipCode.getValue());

        zipCode.setValue("0000a");
        System.out.println(zipCode.getValue());
    }
}
