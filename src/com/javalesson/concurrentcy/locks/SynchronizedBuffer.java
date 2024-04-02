package com.javalesson.concurrentcy.locks;

import com.javalesson.concurrentcy.threadlesson.ColorScheme;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class SynchronizedBuffer {

    public static final Lock monitor = new ReentrantLock();
    private static final Condition canRead = monitor.newCondition();
    private static final Condition canWrite = monitor.newCondition();

    private static int buffer =0;
    private static boolean isEmpty = true;

    public static void main(String[] args) {
        new Thread((SynchronizedBuffer::blockingWrite)).start();
        new Thread((SynchronizedBuffer::blockingRead)).start();
    }
    private static void blockingWrite(){
        for (int i=0;i<10;i++){

        monitor.lock();
            try {
        buffer++;
        isEmpty=false;
            System.out.println(RED+"Writer write: "+buffer);
            canRead.signal();

                canWrite.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                monitor.unlock();
            }
        }
    }
    private static void blockingRead() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
            int readValue = buffer;
            isEmpty = true;
            System.out.println(GREEN+"Reader read from buffer: " + readValue);
            canWrite.signal();

                canRead.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                monitor.unlock();
            }
        }
    }
}
