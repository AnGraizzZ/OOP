package javatests.test19.turn;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Turn {
    public static void main(String[] args) {
        File input = new PathPackage(Turn.class.getPackageName(),"input").getFile();
        File output = new PathPackage(Turn.class.getPackageName(),"output").getFile();
        int quantity;
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)){
            quantity = scanner.nextInt();
            while (scanner.hasNextInt() && quantity>0){
                quantity--;
                numbers.add(scanner.nextInt());
            }
            Collections.reverse(numbers);
            try(PrintWriter writer = new PrintWriter(output)){
                for(int n:numbers){
                    writer.print(n+" ");
                }
            }catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
