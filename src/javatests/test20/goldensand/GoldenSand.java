package javatests.test20.goldensand;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GoldenSand {
    public static void main(String[] args) {
        File input = new PathPackage(GoldenSand.class.getPackageName(),"input.txt").getFile();
        File output = new PathPackage(GoldenSand.class.getPackageName(),"output.txt").getFile();
        ArrayList<Integer> sand = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();
        int money=0;
        try (Scanner scanner = new Scanner(input)){
            int check = 0;
            while (scanner.hasNextInt()){
                if(check<3){
                    sand.add(scanner.nextInt());
                }else{
                    System.out.println(container.add(scanner.nextInt()));
                }
                check++;
            }
            Collections.sort(sand);
            Collections.sort(container);
            for(int i=0;i< sand.size();i++){
                money += sand.get(i)*container.get(i);
            }
            try (PrintWriter writer = new PrintWriter(output)) {
                writer.println(money);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
