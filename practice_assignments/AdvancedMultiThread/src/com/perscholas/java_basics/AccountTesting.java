package com.perscholas.java_basics;

public class AccountTesting extends Account implements Runnable{
    public AccountTesting() {
        super();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 8; i++) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
            }
            if (this.balance > 0){
                this.balance -= 10;
                System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
            } else {
                System.out.println("Not enough in the account for " + Thread.currentThread().getName() + " to withdraw 0");
            }

        }
    }
}
