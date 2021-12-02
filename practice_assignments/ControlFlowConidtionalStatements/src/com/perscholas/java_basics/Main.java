package com.perscholas.java_basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // 1
        int x = 7;
        x = 15;
        if(x < 10){
            System.out.println("Less than 10");
        }

        //2
        x = 7;
        x = 15;
        if(x < 10){
            System.out.println("Less than 10");
        } else {
            System.out.println("Greater than 10");
        }

        //3
        x = 15;
        x = 50;
        if(x < 10){
            System.out.println("Less than 10");
        } else if (x < 20){
            System.out.println("Between 10 and 20");
        } else {
            System.out.println("Greater than or equal to 20");
        }

        //4
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a score between 0 and 100: ");
        int score = s.nextInt();

        if (score < 0 || score > 100){
            System.out.println("Score out of range");
        } else if (score < 60) {
            System.out.println("F");
        } else if (score < 70) {
            System.out.println("D");
        } else if (score < 80) {
            System.out.println("C");
        } else if (score < 90) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }

        //5
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 7: ");
        int dayNum = sc.nextInt();
        String day = "";

        switch (dayNum) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                System.out.println("Out of range");
                break;
        }
        System.out.println(day);
    }
}
