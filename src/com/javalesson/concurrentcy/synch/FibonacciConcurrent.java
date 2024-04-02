package com.javalesson.concurrentcy.synch;

public class FibonacciConcurrent {
    public static int previous = 0;
    public static int current = 1;

    public static void main(String[] args) {
        Thread th1 = new Thread(new FibonacciRunner());
        Thread th2 = new Thread(new FibonacciRunner());
        th1.start();
        th2.start();
    }

    private static synchronized void calcNext(){
        int next = current+previous;
        previous=current;
        current=next;
        System.out.println(current);
    }
    private static class FibonacciRunner implements Runnable{

        @Override
        public void run() {
            for (int i=0; i<10;i++){
                calcNext();
            }
        }
    }
}
