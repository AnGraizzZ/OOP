package javatests.test15.Basketball;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Basketball {
    public static void main(String[] args) {
        PathPackage input = new PathPackage(Basketball.class.getPackageName(), "input.txt");
        File inputFile = input.getFile();
        PathPackage output = new PathPackage(Basketball.class.getPackageName(), "output.txt");
        File outputFile = output.getFile();
        int teamPoint1 = 0;
        int teamPoint2 = 0;
        int[] allPoint;
        try (Scanner inputScanner = new Scanner(inputFile)) {
            while (inputScanner.hasNextInt()) {
                allPoint = Arrays.stream(inputScanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                teamPoint1 += allPoint[0];
                teamPoint2 += allPoint[1];
            }
            try (PrintWriter writer = new PrintWriter(outputFile)) {
                if (teamPoint1 > teamPoint2) {
                    writer.println("1");
                } else if (teamPoint1 < teamPoint2) {
                    writer.println("2");
                } else {
                    writer.println("DRAW");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл output.txt не обнаружен");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл input.txt не обнаружен");
        }
    }
}
