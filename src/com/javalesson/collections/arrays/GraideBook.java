package com.javalesson.collections.arrays;

import java.util.Arrays;

public class GraideBook {
    public static void main(String[] args) {
        int[][] gradesArray =
                {
                        {56,40,67},
                        {80,46,90},
                        {77,64,22},
                        {88,85,56},
                        {56,78,20},
                        {99,58,33},
                        {87,76,29},
                        {100,93,88},
                        {55,38,47},
                        {89,95,38}
                };
        System.out.println("minimal grade "+calcMin(gradesArray));
        //varArgs();
        processArrays();
    }
    private static int calcMin (int[][] grades)
    {
        int min = 100;
        for (int[] row:grades){
            for (int i:row){
                if(min>i){
                    min=i;
                }
            }
        }
        return min;
    }

    private static void varArgs(){
        double a = 0.56;
        double b = 1.92;
        double c = 3.45;
        double d = 5.01;
        System.out.println("среднее 3х"+calcAverage(b,a,c));
        System.out.println("среднее 4х"+calcAverage(b,a,c,d));
    }
    private static double calcAverage(double... args){
        double sum = 0;
        for (double i:args){
            sum+=i;
        }
        return sum/args.length;
    }
    private static void processArrays(){
        double[] dobleArray = {8.9,5.56,8.12,45.0,77.1};
        Arrays.sort(dobleArray);
        System.out.println(Arrays.toString(dobleArray));

        int[] filledArray = new int[7];
        Arrays.fill(filledArray,7);
        System.out.println(Arrays.toString(filledArray));

        int[] intArray = {1,2,3,4,5,6,7};
        int[] arrayCopy = new int[10];
        System.arraycopy(intArray, 0,arrayCopy,0,intArray.length);
        System.out.println(Arrays.toString(arrayCopy));
    }
}
