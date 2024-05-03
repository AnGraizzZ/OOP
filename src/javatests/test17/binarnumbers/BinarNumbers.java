package javatests.test17.binarnumbers;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinarNumbers {
    public static void main(String[] args) {
        File input = new PathPackage(BinarNumbers.class.getPackageName(),"input.txt").getFile();
        File output = new PathPackage(BinarNumbers.class.getPackageName(),"output.txt").getFile();
        int num;
        String bool=null;
        try (Scanner scanner = new Scanner(input)){
            num=scanner.nextInt();
            if(num<2){
                bool="NO";
            }else{
            for(int i=1; i<=num;i*=2){
                if (num == i) {
                    bool = "YES";
                }else{
                    bool = "NO";
                }
            }}
            try(PrintWriter writer = new PrintWriter(output)) {
                writer.println(bool);
            }catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
