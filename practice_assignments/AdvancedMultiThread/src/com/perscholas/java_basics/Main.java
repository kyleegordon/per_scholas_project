package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //1

//        Thread thread1 = new Thread(new ThreadOne(), "thread1");
//        Thread thread2 = new Thread(new ThreadOne(), "thread2");
//
//        thread1.start();
//        thread2.start();

        //2

//       Thread[] threads = new Thread[3];
//
//       for (int i = 0; i < threads.length; i++){
//           threads[i] = new Thread(new ThreadTwo());
//       }
//
//        threads[0].start();
//        threads[0].join();
//        threads[1].start();
//        threads[2].start();

        //3

//        Thread[] threads = new Thread[3];
//
//        threads[0] = new Thread(new ThreadTwo(), "My First Thread");
//        threads[1] = new Thread(new ThreadTwo(), "My Second Thread");
//        threads[2] = new Thread(new ThreadTwo(), "My Third Thread");
//
//        threads[0].start();
//        threads[0].join();
//        threads[1].start();
//        threads[2].start();

        //4

//        Thread thread0 = new Thread(new ThreadFour());
//        Thread thread1 = new Thread(new ThreadFour());
//        Thread thread2 = new Thread(new ThreadFour());
//
//        thread0.setPriority(1);
//        thread1.setPriority(5);
//        thread2.setPriority(10);
//
//        thread0.start();
//        thread1.start();
//        thread2.start();

        //5

//

        //6

//        Message msg = new Message("process it");
//
//        Waiter waiter1 = new Waiter(msg);
//        Thread thread1 = new Thread(waiter1, "waiter1");
//        thread1.start();
//
//        Waiter waiter2 = new Waiter(msg);
//        Thread thread2 = new Thread(waiter2, "waiter2");
//        thread2.start();
//
//        Notifier notifier = new Notifier(msg);
//        Thread thread3 = new Thread(notifier, "notifier");
//        thread3.start();
//
//        System.out.println("All threads are started");
//    }
    }
}
