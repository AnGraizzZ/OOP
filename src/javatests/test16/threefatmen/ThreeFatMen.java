package javatests.test16.threefatmen;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeFatMen {
    public static void main(String[] args) {
        File inputFile = new PathPackage(ThreeFatMen.class.getPackageName(), "input.txt").getFile();
        File outputFile = new PathPackage(ThreeFatMen.class.getPackageName(), "output.txt").getFile();
        int[] allMass;
        boolean Errors = false;
        int max = 0;
        try (Scanner inputScanner = new Scanner(inputFile)) {
            allMass = Arrays.stream(inputScanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < allMass.length - 1; i++) {
                if (allMass[i] < 94 || allMass[i + 1] < 94 || allMass[i] > 727 || allMass[i + 1] > 727) {
                    Errors = true;
                    break;
                }
                max = Math.max(allMass[i], allMass[i + 1]);
            }
            try (PrintWriter writer = new PrintWriter(outputFile)) {
                if (Errors) {
                    writer.println("Error");
                } else {
                    writer.println(max);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
