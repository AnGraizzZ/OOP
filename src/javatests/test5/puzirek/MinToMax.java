package javatests.test5.puzirek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MinToMax {
    public static void main(String[] args) {
        int min;
        int[] a = new int[10];
        int[] b = new int[10];
        Random random = new Random();
        int r;
        for (int i = 0; i < a.length; i++) {
            r = 1 + random.nextInt(100);
            a[i] = r;
            b[i] = r;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    min = a[i];
                    a[i] = a[j];
                    a[j] = min;
                }
                if (b[i] > b[j]) {
                    min = b[i];
                    b[i] = b[j];
                    b[j] = min;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }

}
