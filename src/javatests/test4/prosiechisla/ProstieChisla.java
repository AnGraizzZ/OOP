package javatests.test4.prosiechisla;

import java.util.Scanner;

public class ProstieChisla {
    public static void main(String[] args) {
        double a = 0;
        double b=0;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Введите число");
                a = scanner.nextInt();
                ex = false;

            } catch (Exception e) {
                System.out.println("Это не число");
                scanner.nextLine();
            }
        } while (ex);

        b = Math.sqrt(a);
        for (int i=2;i<=b;i++){
            if(a%i==0){
                System.out.println(a%i);
                break;
            }
            System.out.println(a%i);
        }


    }
}
