package com.perscholas.java_basics;

import java.sql.SQLOutput;

public class MyThreadRunnable implements Runnable{
    @Override
    public void run() {

        int count = 1;
        while(count < 10){
            System.out.println(Thread.currentThread().getId() + " : " + count);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Thread Interrupted");
                e.printStackTrace();
            }
            count++;
        }
//        System.out.println("Executing Runnable Thread: " + Thread.currentThread().getId());
    }
}
