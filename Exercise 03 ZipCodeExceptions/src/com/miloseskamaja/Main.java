package com.miloseskamaja;

public class Main {

    public static void main (String [] args){
        try{
            ZipCode zipCode = new ZipCode();

            zipCode.setValue("123456789");
            System.out.println(zipCode.getValue());
            zipCode.setValue("0000a8");
            System.out.println(zipCode.getValue());
        } catch (WrongZipCodeFormatException ex){
            System.err.println(ex.getMessage());
        }

    }
}

