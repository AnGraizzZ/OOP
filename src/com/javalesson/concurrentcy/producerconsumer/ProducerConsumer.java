package com.javalesson.concurrentcy.producerconsumer;

import com.javalesson.concurrentcy.threadlesson.ColorScheme;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class ProducerConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable{
        String[] massages = {
                "Наше дело не так однозначно, как может показаться",
                "Значимость этих проблем настолько очевидна",
                "Также как граница обучения кадров создаёт необходимость",
                "Современные технологии достигли такого уровня",
                "Банальные, но неопровержимые выводы, а также тщательные",
                "Но стремящиеся вытеснить традиционное производство",
                "С другой стороны, выбранный нами инновационный путь напрямую",
                "DONE"
        };

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        private void produce() throws InterruptedException {
            Random r= new Random();
            for (int i=0; i< massages.length;i++){
                queue.put(massages[i]);
                System.out.println(GREEN+"Producing "+massages[i]+ ". Queue size is "+ queue.size());
                Thread.sleep(r.nextInt(1000));
            }
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void consume() throws InterruptedException {
            Random r = new Random();
            while (true){
                String massage = queue.take();
                System.out.println(RED+"Consuming "+massage+". Queue size is "+queue.size());
                if(!"DONE".equals(massage)){
                    Thread.sleep(r.nextInt(3000));
                }else {
                    return;
                }
            }
        }
    }
}
