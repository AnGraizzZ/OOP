package com.javalesson.collections;

import java.security.SecureRandom;

public class Dies {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] frequency = new int[7];

            for (int i = 0; i < 1000; i++) {
                ++frequency[1 + random.nextInt(6)];
            }
            for (int i : frequency) {
                System.out.println(" выпало " + i + " раз");

            }



        // MultiDinArray();
    }

    private static void MultiDinArray(){
        int[][] a ={{1,2},{3,4},{2,3,4,5}};
        int[][] b = new int[3][3];
        int[][] c = new int[2][];
        c[0] = new int[2];
        c[1] = new int[3];

        for (int i=0; i< a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
