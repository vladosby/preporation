package com.preparation.cuncurrency.simple.thread;

/**
 * Description of class HelloWorldThread
 *
 * @created: 9/13/2017
 */
public class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello world");
        System.out.println(Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        Thread helloWorldThread = new HelloWorldThread();
        helloWorldThread.setName("helloWorldThread");

        Thread anonymousThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Running anonymous thread...");
            System.out.println(Thread.currentThread().getName());
        });

        anonymousThread.setName("anonymousThread");

        anonymousThread.start();
        helloWorldThread.start();
    }
}
