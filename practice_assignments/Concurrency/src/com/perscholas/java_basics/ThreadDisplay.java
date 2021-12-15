package com.perscholas.java_basics;

public class ThreadDisplay extends ThreadTwo {
    private final ThreadTwo threadCount;

    public ThreadDisplay(ThreadTwo threadCount) {
        this.threadCount = threadCount;

    }

    @Override
    public void run() {
        synchronized (this) {
            while(!threadCount.isFinished){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Second thread display count: " + threadCount.getCount());
        }
    }

}
