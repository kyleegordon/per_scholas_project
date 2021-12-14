package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("Thread 1");
//        myThread1.start();

        Thread myThread2 = new Thread( new MyThreadRunnable(), "myThread2");
        Thread myThread3 = new Thread( new MyThreadRunnable(), "myThread3");
        myThread2.start();
        myThread3.start();

//        myThread2.interrupt();
    }
}
