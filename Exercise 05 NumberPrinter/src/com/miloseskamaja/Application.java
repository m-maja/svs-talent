package com.miloseskamaja;

public class Application {
    public static void main (String [] args){
        if (args.length < 2){
            System.out.println("Too few arguments");
            return;
        }

        long countTo =  Integer.parseInt(args[0]);
        int milliseconds = Integer.parseInt(args[1]) * 1000;

        NumberPrinter thread = new NumberPrinter(countTo);
        thread.start();

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (thread.isAlive())
        {
            thread.interrupt();
            System.out.println("NumberPrinter is successfully interrupted, and the thread did not finish for " + milliseconds/1000 + " seconds");
        }
    }
}
