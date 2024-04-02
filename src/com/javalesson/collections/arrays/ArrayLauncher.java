package com.javalesson.collections.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLauncher {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myArray = new int[8];
        int elem = 0;
        for (int j=0; j<myArray.length; j++)
        {
            elem=j+1;
            System.out.println("Введите "+elem+" элемент массива");
            myArray[j] = scanner.nextInt();
        }

        sort(myArray);
        for (int i=0;i<myArray.length;i++){
            System.out.println("Элемент "+i+"="+myArray[i]);
        }
    }
    private static int[] sort(int[] array){
        for (int i=0; i<array.length;i++)
        {
            for (int j=0; j<array.length-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }
}
