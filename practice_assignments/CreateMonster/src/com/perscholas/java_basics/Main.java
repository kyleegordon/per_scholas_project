package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

        //Declare instances of the superclass, substituted by subclassed
        Monster m1 = new FireMonster("r2u2");
        Monster m2 = new WaterMonster("u2r2");
        Monster m3 = new StoneMonster("r2r2");

        //Invoke actual implementation
        System.out.println(m1.attack());
        System.out.println(m2.attack());
        System.out.println(m3.attack());

        //m1 dies, generate new instance
        m1 = new StoneMonster("u2u2");
        System.out.println(m1.attack());

        //We have a problem here
        Monster m4 = new Monster();
        System.out.println(m4.attack());
    }
}
