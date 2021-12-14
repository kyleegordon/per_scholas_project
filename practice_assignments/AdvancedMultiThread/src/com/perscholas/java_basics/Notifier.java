package com.perscholas.java_basics;

public class Notifier implements Runnable{
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }

        synchronized (msg) {
            msg.setMessage(name + " Notifier word done");
            msg.notify();

        }

    }
}
