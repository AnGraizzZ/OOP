package com.javalesson.concurrentcy.threadlesson;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class ConcurrentMain {
    public static void main(String[] args) {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();
        simpleThread.interrupt();
        System.out.println("hello from main");
        SimpleThread simpleThread1 = new SimpleThread();
        simpleThread1.start();
        Thread simpleRunner = new Thread(new SimpleRunner());
        simpleRunner.start();
        new Thread(()->{
            System.out.println("Lampda Runner");
        }).start();
    }

}

class SimpleThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i<10; i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW+"Warning - "+currentThread().getName()+"поток прерван");
                return;
            }
            System.out.println(GREEN+"INFO - "+currentThread().getName()+" - "+i);
        }
    }


}
class SimpleRunner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<10; i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW+"Warning - "+Thread.currentThread().getName()+"поток прерван");
                return;
            }
            System.out.println(GREEN+"INFO R - "+Thread.currentThread().getName()+" - "+i);
        }
    }
}