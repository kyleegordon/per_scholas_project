package com.perscholas.java_basics;

public class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }

        }
    }
}
