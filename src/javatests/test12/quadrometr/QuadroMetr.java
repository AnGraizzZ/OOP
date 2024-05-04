package javatests.test12.quadrometr;

import javatests.PathPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class QuadroMetr {
    public static void main(String[] args) throws IOException {
        PathPackage input = new PathPackage(QuadroMetr.class.getPackageName(),"input.txt");
        File inputFile = input.getFile();
        PathPackage output = new PathPackage(QuadroMetr.class.getPackageName(),"output.txt");
        File outputFile = output.getFile();

        Scanner inputScanner = new Scanner(inputFile);
        String data = inputScanner.nextLine();
        String[] splitData = data.split(" ");
        ArrayList<Integer> intData = new ArrayList<>();
        for(String sd:splitData){
            intData.add(Integer.parseInt(sd));
        }
        int sulfid =2;
        for(int id:intData){
            sulfid*=id;
        }
        PrintWriter writer = new PrintWriter(outputFile);
        writer.println(sulfid);
        writer.close();
    }
}
