package com.javalesson.exeption;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExHandMain {
    public static void main(String[] args) {
        try {
            extFix();
        } catch (NullPointerException e) {
            System.out.println("NPE");
            e.getSuppressed();
            e.printStackTrace();
        }
    }

    private static void extFix() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do {

            try(PrintWriter writer = new PrintWriter(new FileWriter("out.txt"));) {
                System.out.println("Введите делимое ");
                int numerator = scanner.nextInt();
                System.out.println("Введите делитель ");
                int denominator = scanner.nextInt();
                //System.out.println("Результат деления " + divide(numerator, denominator));
                //int[] intArr = new int[1];
                //int i = intArr[1];

                writer.println("Result: "+divide(numerator, denominator));
                continueLoop=false;
            } catch (ArithmeticException | InputMismatchException e){//обработка сразу двух ошибок
                System.out.println("Ошибка: "+e);
                scanner.nextLine();
                System.out.println("Можно использовать только числа со значением != 0 ");

            } catch (IOException e) {
                System.out.println("не удалось открыть файл");
                throw new RuntimeException(e);
            }catch (IndexOutOfBoundsException e){
                throw new InvalidInputParamExeption("Выход за пределы массива"+e);
            }
            finally {
                System.out.println("Финальный блок вызван");


            }
        } while (continueLoop);
        System.out.println("Работа программы завершена");
    }

    private static int divide (int numerator, int denominator) throws ArithmeticException, NullPointerException{
        return numerator/denominator;
    }
}
