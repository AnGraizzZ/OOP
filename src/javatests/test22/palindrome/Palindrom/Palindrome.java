package javatests.test22.palindrome.Palindrom;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        File input = new PathPackage(Palindrome.class.getPackageName(),"input.txt").getFile();
        File output = new PathPackage(Palindrome.class.getPackageName(),"output.txt").getFile();
        String[] numberString;
        boolean isPalindrome=true;
        int revers;
        try(Scanner scanner = new Scanner(input)) {
            numberString = scanner.nextLine().split("");
            System.out.println(numberString.length);
            for(int i=0; i<numberString.length/2;i++){
                revers = numberString.length-1-i;
                    if(!numberString[i].equals(numberString[revers])){
                        isPalindrome=false;
                        break;
                }
            }
            try(PrintWriter writer = new PrintWriter(output)) {
                writer.println(isPalindrome);
            }catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
