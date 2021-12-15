package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

        //1.a
//
//        Thread t1 = new Thread(new ThreadOne());
//        t1.start();

        //1.b, c

//        Thread t1 = new Thread(new ThreadOne());
//        Thread t2 = new Thread(new ThreadOne());
//        Thread t3 = new Thread(new ThreadOne());
//        Thread t4 = new Thread(new ThreadOne());
//        Thread t5 = new Thread(new ThreadOne());
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();

        //2.a, b

//        Runnable shared = new ThreadTwo();
//        Thread t1 = new Thread(shared);
//        Thread t2 = new Thread(shared);
//        t1.start();
//        t2.start();


        //3.a, b
        ThreadTwo shared = new ThreadTwo();
        Thread t1 = new Thread(shared);
        Thread t2 = new Thread(new ThreadDisplay(shared));

        t1.start();
        t2.start();





    }
}
