package com.perscholas.java_basics;

public class ThreadOne implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getId());
    }
}
