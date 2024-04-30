package com.javapluslesson.bigo;

import java.util.Scanner;

public class OFromOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int number = scanner.nextInt();
        // Количество циклов ограничено константным числом.
        // Время выполнения массива не зависит от введенных данных
        for (int i=0;i<5;i++){
            System.out.println(number);
        }
    }
}
