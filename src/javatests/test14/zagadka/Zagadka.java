package javatests.test14.zagadka;

import javatests.PathPackage;
import javatests.test13.salary.Salary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zagadka {
    public static void main(String[] args) throws FileNotFoundException {


        PathPackage input = new PathPackage(Zagadka.class.getPackageName(), "input.txt");
        File inputFile = input.getFile();
        PathPackage output = new PathPackage(Zagadka.class.getPackageName(), "output.txt");
        File outputFile = output.getFile();

        Scanner scanner = new Scanner(inputFile);
        int num = scanner.nextInt();
        int constanta = 9;
        int num2 = constanta - num;
        PrintWriter writer = new PrintWriter(outputFile);
        writer.print(num+""+constanta+""+num2);
        writer.close();
    }

}
