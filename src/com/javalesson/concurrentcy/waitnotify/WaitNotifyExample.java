package com.javalesson.concurrentcy.waitnotify;

import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Message  message = new Message();

        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }

    private static class Producer implements Runnable {
        private final Message message;

        Producer(Message message) {
            this.message = message;
        }

        String[] text = {
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
            for (String t : text) {
                synchronized (message) {
                    System.out.println(BLUE + "Producing message " + t);
                    message.setMessage(t);
                    message.notify();
                    if (!"DONE".equals(t)) {
                        message.wait();
                    } else {
                        return;
                    }

                }
                Thread.sleep(500);
            }
        }
    }

    private static class Consumer implements Runnable {
        private final Message message;

        Consumer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void consume() throws InterruptedException {
            while (true){
                Thread.sleep(1000);
                synchronized (message){
                    System.out.println(RED+"Consuming message "+message.getMessage());
                    if (!"DONE".equals(message.getMessage())) {
                        message.notify();
                        message.wait();
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
