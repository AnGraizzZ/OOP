package com.javapluslesson.quicksort;

import java.util.Arrays;
import java.util.Random;

public class Runner {


    public static void main(String[] args) {
        int[] array = new int[30];
        QuickSort quickSort = new QuickSort();
        Random random = new Random();
        for (int i=0; i<array.length;i++){
            array[i]=-10+random.nextInt(64);
        }
        System.out.println(Arrays.toString(array));
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
