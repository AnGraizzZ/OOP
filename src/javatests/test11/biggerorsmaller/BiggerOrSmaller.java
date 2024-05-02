package javatests.test11.biggerorsmaller;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BiggerOrSmaller {
    public static void main(String[] args) throws IOException {
        PathPackage pathInput = new PathPackage(BiggerOrSmaller.class.getPackageName(),"input.txt");
        PathPackage pathOutput = new PathPackage(BiggerOrSmaller.class.getPackageName(),"input.txt");
        File inputPath = pathInput.getFile();
        File outputPath = pathOutput.getFile();
        int[] data;
        System.out.println(inputPath);
        System.out.println(outputPath);

        data = inputFileRead(inputPath);
        if(data!=null){
            String equalsReturn = equalsData(data);
            outputFileWriter(outputPath,equalsReturn);
            System.out.println(equalsReturn);
        }


        System.out.println();

    }
    public static int[] inputFileRead(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner(inputFile);
        int kolLine=0;
        while (inputScanner.hasNextLine()){
                kolLine++;
            System.out.println(inputScanner.nextLine());
        }
        inputScanner.close();
        inputScanner = new Scanner(inputFile);
        if(kolLine>=2){
            int[] arrInt = new int[2];
            for(int i=0; i<arrInt.length;i++){
                arrInt[i]=Integer.valueOf(inputScanner.nextLine());
            }
            return arrInt;
        }else{
            System.out.println("В файле input.txt недостаточно данных");
            return null;
        }

    }

    public static void outputFileWriter(File outputFile, String equalsData) throws IOException {

        PrintWriter writer = new PrintWriter(outputFile);
        writer.println(equalsData);
        writer.close();
    }

    public static String equalsData(int[] data){
        if(data!=null){
            if(data[0]<data[1]){
                return "<";
            }
            if(data[0]>data[1]){
                return ">";
            }
            return "=";
        }
        return "";
    }
}
