package com.javalesson.concurrentcy.volatilelesson;

import com.javalesson.concurrentcy.threadlesson.ColorScheme;

public class VolatileMain {
    private static volatile int counter;
    public static void main(String[] args) {
        new SimpleWriter().start();
        new SimpleReader().start();
    }
    private static class SimpleWriter extends Thread{
        @Override
        public void run() {
            int localCounter = counter;
            for (int i=0 ; i<10;i++){
                System.out.println(ColorScheme.RED+"Writer increments counter "+ (localCounter+1));
                counter = ++localCounter;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private static class SimpleReader extends Thread{
        @Override
        public void run() {
            int localCounter = counter;
                while (localCounter<9){
                    if(localCounter!=counter){
                        System.out.println(ColorScheme.CYAN+"Reader reads counter "+ counter);
                        localCounter=counter;
                    }

                }

        }
    }
}
