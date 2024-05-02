package javatests.test13.salary;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) throws FileNotFoundException {
        PathPackage input = new PathPackage(Salary.class.getPackageName(), "input.txt");
        File inputFile = input.getFile();
        PathPackage output = new PathPackage(Salary.class.getPackageName(), "output.txt");
        File outputFile = output.getFile();
        Scanner scanner = new Scanner(inputFile);
        ArrayList<Integer> salary = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            salary.add(scanner.nextInt());
        }
        int min = Collections.min(salary);
        int max = Collections.max(salary);
        PrintWriter writer = new PrintWriter(outputFile);
        writer.println(max - min);
        writer.close();
    }
}