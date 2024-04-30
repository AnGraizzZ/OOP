package com.javapluslesson.bigo;

import java.util.Scanner;

public class OFromNK {
    public static void main(String[] args) {
        Scanner scannerN = new Scanner(System.in);
        Scanner scannerK = new Scanner(System.in);
        System.out.println("Введите число N");
        int N = scannerN.nextInt();
        System.out.println("Введите число K");
        int K = scannerK.nextInt();
        // Количество циклов ограничено введенными данными.
        // Время выполнения массива пропорционально зависит от объема данных
        for (int i=0;i<N;i++){
            System.out.println(N);
        }
        //теперь уже каждого цикла
        for (int i=0;i<K;i++){
            System.out.println(K);
        }
    }
}
