package javatests.test21.alcohol;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Alcohol {
    public static void main(String[] args) {


        File input = new PathPackage(Alcohol.class.getPackageName(), "input.txt").getFile();
        File output = new PathPackage(Alcohol.class.getPackageName(), "output.txt").getFile();
        ArrayList<Integer> atoms = new ArrayList<>();
        int quantity = 0;
        {
            try (Scanner scanner = new Scanner(input)){
                while (scanner.hasNextInt()){
                    atoms.add(scanner.nextInt());
                }
                System.out.println(atoms.get(2));
                for(int o=1;o<=atoms.get(2);o++){
                    if(o*2<=atoms.get(0)&&o*6<=atoms.get(1)){
                        quantity++;
                    }else {
                        break;
                    }
                }
                try(PrintWriter writer=new PrintWriter(output)){
                    writer.println(quantity);
                }catch (FileNotFoundException e){
                    throw  new RuntimeException(e);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
