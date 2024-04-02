package com.javalesson.concurrentcy.locks;

import com.javalesson.concurrentcy.threadlesson.ColorScheme;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class WaitingQueue {
    public static void main(String[] args) throws InterruptedException {
        int operators =3;
        int customers = 43;
        SemaphoredServicesDesk servicesDesk = new SemaphoredServicesDesk(operators,customers);
        ExecutorService executorService = Executors.newCachedThreadPool();

        IntStream.range(0,customers)
                .forEach(client->executorService.submit(()->{
                    servicesDesk.connect();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(GREEN+"Number of connected customers"+ servicesDesk.getCustomersConnected());
                    System.out.println(GREEN+"Number of customers in a queue"+ servicesDesk.getCustomersWaiting());
                }));
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }
    private static class SemaphoredServicesDesk{
        private AtomicInteger connectedCustomers = new AtomicInteger();
        private AtomicInteger customerQueued;
        private Semaphore semaphore;
        public SemaphoredServicesDesk(int operatorsNum, int customersNumber){
            semaphore = new Semaphore(operatorsNum);
            customerQueued = new AtomicInteger(customersNumber);

        }
        public void connect(){
            Random random = new Random();

            try {
            semaphore.acquire();
            connectedCustomers.incrementAndGet();
            customerQueued.decrementAndGet();
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                disconnect();
            }
        }

        private void disconnect() {
            semaphore.release();
            connectedCustomers.decrementAndGet();
        }

        private int getCustomersConnected(){
            return connectedCustomers.get();
        }

        private int getCustomersWaiting(){
            return customerQueued.get();
        }
    }
}
