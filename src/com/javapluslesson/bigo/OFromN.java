package com.javapluslesson.bigo;

import java.util.Scanner;

public class OFromN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        int a=0;
        // Количество циклов ограничено введенными данными.
        // Время выполнения массива пропорционально зависит от объема данных
        for (int i=0;i<number;i++){
            System.out.println(number);
        }
        a++;
        System.out.println(a);
    }
}
