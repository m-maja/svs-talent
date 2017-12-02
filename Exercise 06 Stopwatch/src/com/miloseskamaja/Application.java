package com.miloseskamaja;

import java.util.Scanner;

public class Application {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to stop the stopwatch");
        System.out.println("Enter 2 to pause the stopwatch");
        System.out.println("Enter 3 to resume the stopwatch");
        int action;

        Stopwatch stopWatch = new Stopwatch();
        stopWatch.start();
        label:
        while (true) {
            action = input.nextInt();
            switch (action) {
                case 1:
                    stopWatch.finishStopwatch();
                    break label;
                case 2:
                    stopWatch.pauseStopwatch();
                    break;
                case 3:
                    stopWatch.resumeStopwatch();
                    break;
                default:
                    System.out.println("Wrong action!");
            }
        }

    }

}
