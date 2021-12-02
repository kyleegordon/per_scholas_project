package com.perscholas.java_basics;


public class Main {

    public static void main(String[] args) {
	// prints Fizz if divisible by 3, Buzz if divisible by 5
        int num = 100;
        String word;
        for (int i = 1; i <= num; i++){
            word = "";

            if (i % 3 == 0){
                word = word.concat("Fizz");
            }

            if (i % 5 == 0){
                word = word.concat("Buzz");
            }

            if (word.equals("")) {
                System.out.println(i);
            } else {
                System.out.println(word);
            }
        }

    }
}
