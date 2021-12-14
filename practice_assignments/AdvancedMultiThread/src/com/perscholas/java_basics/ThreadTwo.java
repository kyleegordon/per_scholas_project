package com.perscholas.java_basics;

public class ThreadTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread[" + Thread.currentThread().getName() + "]");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }

        }
    }
}
