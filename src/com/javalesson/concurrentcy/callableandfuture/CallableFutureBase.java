package com.javalesson.concurrentcy.callableandfuture;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Timer{
    public Instant start;
    public Instant end;

    public double timeInSeconds(){
        return Duration.between(start,end).toMillis()/1000.0;
    }
}
public class CallableFutureBase {
    public static void main(String[] args) {
        List<Future<Double>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<30;i++){
            futures.add(executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Timer timer = new Timer();
                    Random random = new Random();
                    timer.start = Instant.now();
                    int r = random.nextInt(5000);
                    Thread.sleep(r);
                    timer.end = Instant.now();
                    return timer.timeInSeconds();
                }
            }));
        }
        executorService.shutdown();
        futures.stream()
                .map(f-> {
                    try {
                        return f.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);

                    }

                })
                .forEach(t->System.out.println("Время выполнения потока: "+t));
    }
}
