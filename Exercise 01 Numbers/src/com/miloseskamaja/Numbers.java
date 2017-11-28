package com.miloseskamaja;

public class Numbers {
    public static void main(String[] args) {
        int number = 0;
        for (int i = 0; ; i++) {
            switch (args[i]) {
                case "zero":
                    number += 0;
                    break;
                case "one":
                    number += 1;
                    break;
                case "two":
                    number += 2;
                    break;
                case "three":
                    number += 3;
                    break;
                case "four":
                    number += 4;
                    break;
                case "five":
                    number += 5;
                    break;
                case "six":
                    number += 6;
                    break;
                case "seven":
                    number += 7;
                    break;
                case "eight":
                    number += 8;
                    break;
                case "nine":
                    number += 9;
                    break;
            }
            if (i == args.length - 1) {
                break;
            }
            number *= 10;
        }

        System.out.print(number);
    }
}
