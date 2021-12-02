package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

        //1
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        //2
        int count = 0;

        while (count <= 100) {
            System.out.println(count);
            count += 10;
        }

        //3
        count = 1;

        do {
            System.out.println(count);
            count++;
        } while (count <= 10);

        //4
        for (int i = 1; i <= 100; i++) {
            if (i > 24 && i < 76) {
                continue;
            }
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }

        //5
        for (int i = 1; i <= 100; i++) {
            if (i > 50) {
                break;
            }
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }

        //6
        for (int i = 1; i <= 2; i++) {
            System.out.println("Week " + i + ": ");
            for (int j = 1; j <= 5; j++){
                System.out.println("Day " + j);
            }
        }

        //7
        for (int i= 10; i <= 200; i++){
            String original = Integer.toString(i);
            String reversed = "";

            for (int j = original.length() - 1; j >= 0; j--){
                reversed += original.charAt(j);
            }

            if (original.equals(reversed)){
                System.out.print(i + ", ");
            }
        }

        //8
        System.out.println();
        for (int i = 0; i <= 9; i++){
            double num = ((Math.pow(((1 + Math.sqrt(5))/2), i) - (Math.pow(((1 - Math.sqrt(5))/2), i)))) / Math.sqrt(5);
            System.out.print((int)num + ", ");
        }

        //9
        for (int i=0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }
}
