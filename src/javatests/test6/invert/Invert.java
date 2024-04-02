package javatests.test6.invert;

import java.util.Random;

public class Invert {
    public static void main(String[] args) {
        int temp = 0;
        int[] a = new int[10];
        Random random = new Random();
        int r;
        for (int i = 0; i < a.length; i++) {
            r = 1 + random.nextInt(100);
            a[i] = r;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[i];
            a[i] = temp;
        }
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
    }


}
