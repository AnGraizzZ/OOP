package javatests.test24.statemachine;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StateMachine {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new PathPackage(StateMachine.class.getPackageName(), "input.txt").getFile();
        File output = new PathPackage(StateMachine.class.getPackageName(), "output.txt").getFile();
        int quantity;
        String[] line;
        int[] num = new int[2];
        PrintWriter writer = new PrintWriter(output);

        try (Scanner scanner = new Scanner(input)) {
            quantity = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < quantity; i++) {
                line = scanner.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    num[j] = Integer.parseInt(line[j]);
                }
                writer.println((19 * num[1]) + ((num[0] + 239) * (num[0] + 366) / 2));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
