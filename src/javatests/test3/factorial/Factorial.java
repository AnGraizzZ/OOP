package javatests.test3.factorial;

import java.io.Console;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        int a = 0;
        int b=0;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Введите число");
                a = scanner.nextInt();
                ex = false;
                b = a;
            } catch (Exception e) {
                System.out.println("Это не число");
                scanner.nextLine();
            }
        } while (ex);

        while (a > 1) {
            b = b * (a - 1);
            a--;
        }
        System.out.println(b);
    }
}
