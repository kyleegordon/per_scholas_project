package com.perscholas.java_basics;

public class ThreadTwo implements Runnable{
    private int count = 0;
    protected boolean isFinished = false;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i < 1000000; i++) {
                this.count++;
            }
            System.out.println(Thread.currentThread().getName() + " count: " + this.count);
            this.isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getCount() {
        return count;
    }
}
