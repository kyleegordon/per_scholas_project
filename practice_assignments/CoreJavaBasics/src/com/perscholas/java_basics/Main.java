package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {
        //Exercise 1
        int firstInt = 4;
        int secondInt = 6;
        int resultInt = firstInt + secondInt;
        System.out.println(resultInt);

        //Exercise 2
        double firstDouble = 10.5;
        double secondDouble = 3.7;
        double resultDouble = firstDouble + secondDouble ;
        System.out.println(resultDouble );

        //Exercise 3
        int a = 7;
        double b = 6.9;
        double result = a + b ;
        System.out.println(result);

        //Exercise 4
        double c = 15;
        int d = 2;
        double resultDivision = c / d ;
        System.out.println(resultDivision);

        //Exercise 5
        double e = 25;
        double f = 7;
        double resultDivisionDouble = e / f ;
        System.out.println(resultDivisionDouble);
        int castResult = (int) resultDivisionDouble;
        System.out.println(castResult);

        //Exercise 6
        int x = 5;
        int y = 6;
        double q = y / x;
        System.out.println(q);
        q = (double) y / x;
        System.out.println(q);

        //Exercise 7
        final double TAX_RATE = 1.07;
        double price = 73.56;
        double total = price * TAX_RATE;
        System.out.println(String.format("%.2f", total));

        //Exercise 8
        final double SALES_TAX = 1.07;
        double coffee = 3.75;
        double latte = 6.25;
        double tea = 4.50;
        double subtotal = (coffee * 3) + (latte * 4) + (tea * 2);
        double totalSale = SALES_TAX * subtotal;
        System.out.println(String.format("%.2f", totalSale));
    }
}
