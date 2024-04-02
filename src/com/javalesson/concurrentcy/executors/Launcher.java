package com.javalesson.concurrentcy.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class Launcher {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        boolean isDaemon = true;
        System.out.println(RED+"Старт исполняемого потока");
        GCDRunnable r = new GCDRunnable();
//        runInOneThread(r, isDaemon);
        Thread.sleep(100);
        System.out.println(RED+"Остановка исполняемого потока");
        runWithExecutor(r,isDaemon);
    }
    private  static  void runInOneThread(GCDRunnable r, boolean Daemon) throws InterruptedException {
        Thread th1 = new Thread(r);
        th1.setDaemon(Daemon);
        th1.start();
       //th1.interrupt();
    }

    private static void runWithExecutor(GCDRunnable r, boolean Daemon) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i=0; i<5;i++){
            executorService.execute(r);
        }
        executorService.shutdown();
    }
}
