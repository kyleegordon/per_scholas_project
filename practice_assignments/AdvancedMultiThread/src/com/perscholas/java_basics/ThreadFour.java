package com.perscholas.java_basics;

public class ThreadFour implements Runnable{
    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println("running thread name is:" + Thread.currentThread().getName());
            System.out.println("running thread priority is:" + Thread.currentThread().getPriority());
            System.out.println("=================================");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }

        }
    }
}
