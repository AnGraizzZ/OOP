package com.javapluslesson.bigo;

import java.util.Arrays;
import java.util.Random;

public class OFromLogN {
    public static void main(String[] args) {
        //создаем массив, заполняем его случайными элементами и запоминаем последний добавленный элемент
        int[] array = new int[10];
        Random random = new Random();
        int last = 0;
        for(int i=0; i< array.length;i++){
            array[i]=1+random.nextInt(64);
            last = array[i];
        }
        //сортируем массив и отправляем его и последний добавленный элемент в метод
        Arrays.sort(array);
        System.out.println("Массив: "+Arrays.toString(array));
        System.out.println("Искомое число: "+last);
        logarifm(array, last);
    }

    public static void logarifm(int[] array, int target){
        // находим середину массива и проверяем равен ли он искомому элементу (последнему добавленному)
        int search = array.length/2;
        int binar = search;
        while (array[search]!=target){
            // binar число для поиска середины части массива
            if(binar>1) binar/=2; else binar=1;
            //если искомое число больше проверяемого, ищем его в правой части
            if (array[search]<target) search+=binar;
            //если искомое число меньше проверяемого, ищем его в левой части
            if(array[search]>target) search-=binar;
        }
        System.out.println("Искомое число на позиции: "+search);
    }
}
