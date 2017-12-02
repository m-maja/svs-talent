package com.miloseskamaja;

public class NumberPrinter extends Thread {
    private long end;

    public NumberPrinter(long end) {
        this.end = end;
    }

    @Override
    public void run() {
        for (long i = 0 ; (i < end) && !isInterrupted(); i++){
            System.out.println(i);
        }
        if (!isInterrupted())
            System.out.println("Thread finished on time.");
    }
}