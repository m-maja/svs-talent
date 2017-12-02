package com.miloseskamaja;

public class Stopwatch extends Thread {

    private static final int RUNNING = 0;
    private static final int ENDED = 1;
    private static final int PAUSED = 2;

    private int seconds;
    private int minutes;
    private int hours;
    private int state;

    Stopwatch() {
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    @Override
    public void run() {
        state = RUNNING;

        while (state != ENDED){
            while (state == PAUSED){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getTime());
            System.out.flush();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds++;
            if (seconds == 60){
                seconds = 0;
                minutes ++;
                if (minutes == 60){
                    hours++;
                }
            }
        }
    }

    public String getTime (){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void finishStopwatch(){
        state = ENDED;
    }

    public void pauseStopwatch(){
        state = PAUSED;
    }

    public void resumeStopwatch(){
        state = RUNNING;
    }
}