package com.perscholas.java_basics;

public class MyThread  extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Executing thread: " + Thread.currentThread().getId());
//        super.run();
    }
}
