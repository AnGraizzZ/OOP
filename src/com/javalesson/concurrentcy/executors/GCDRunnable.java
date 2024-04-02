package com.javalesson.concurrentcy.executors;

import java.util.Random;
import static com.javalesson.concurrentcy.threadlesson.ColorScheme.*;

public class GCDRunnable extends Random implements  Runnable {
    public GCDRunnable() {
    }

    @Override
    public void run() {
        String threadDescription = Thread.currentThread().getName();

        System.out.println(BLUE+"Запуск "+threadDescription);
        for (int i=0; i<10_000_000; i++){
            int a = nextInt();
            int b = nextInt();
            if(i%10_000==0){
                if(!Thread.interrupted()) {
                    int gcd = computeGCD(a, b);
                    if (gcd > 5) {
                        System.out.println(GREEN + "В потоке " + threadDescription + ". Результат GCD деления " + a + " и " +
                                b + " = " + gcd);
                    }
                }else {
                    System.out.println(YELLOW+"Поток прерван");
                    return;
                }
            }
        }
        System.out.println(BLUE+"Остановка "+threadDescription);
    }

    private  int computeGCD(int number1, int number2){
        if (number2==0){
            return number1;
        }else {
            return computeGCD(number2, number1%number2);
        }
    }
}
