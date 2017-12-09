package com.seavus.readers.commandreaders;

import com.seavus.exceptions.WrongComandException;

import java.io.Console;
import java.util.Scanner;

public class ConsoleCommandReader implements CommandReader {
    private Scanner scanner;

    public ConsoleCommandReader() {
       scanner = new Scanner(System.in);
    }

    @Override
    public int readCommand() {
        int action;
        Scanner scanner = new Scanner(System.in);
        try {
            action = scanner.nextInt();
        } catch (Exception ex){
            throw new WrongComandException("Can't parse your command");
        }

        return action;
    }
}
