package javatests.test23.keyboard;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        File input = new PathPackage(Keyboard.class.getPackageName(),"input.txt").getFile();
        File output = new PathPackage(Keyboard.class.getPackageName(),"output.txt").getFile();
        String symbol;

        try (Scanner scanner = new Scanner(input)){
            symbol = scanner.nextLine();
            try(PrintWriter writer=new PrintWriter(output)) {
                writer.println(algorithmFindSymbol(symbol));
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public static String algorithmFindSymbol(String symbol){
        List<String> symbols = Arrays.asList("q","w","e","r","t","y","u","i","o","p",
                                             "a","s","d","f","g","h","j","k","l",
                                             "z","x","c","v","b","n","m");
        ArrayList<String> keyboard = new ArrayList<>(symbols);
        if(!symbol.equals("m")){
            return keyboard.get(keyboard.indexOf(symbol)+1);
        }else {
            return "q";
        }
    }
}
