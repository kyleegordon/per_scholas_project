package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

       KidUser person1 = new KidUser(10, "Kids");
       KidUser person2 = new KidUser(18, "Fiction");

       person1.registerAccount();
       person1.requestBook();
       System.out.println();

       person2.registerAccount();
       person2.requestBook();
       System.out.println();

       AdultUser person3 = new AdultUser(5, "Kids");
       AdultUser person4 = new AdultUser(23, "Fiction");

       person3.registerAccount();
       person3.requestBook();
       System.out.println();

       person4.registerAccount();
       person4.requestBook();

    }
}
