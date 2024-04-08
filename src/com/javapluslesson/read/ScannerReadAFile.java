package com.javapluslesson.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScannerReadAFile {
    public static void main(String[] args) throws FileNotFoundException {
        String s = File.separator;
        String path = "E:"+s+"User"+s+"Desktop"+s+"Test.txt";

        File file = new File(path);

        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        List<Integer> intNum = new ArrayList<>();

        int sum=0;
        for (int i=0; i<numbers.length; i++){
            intNum.add(i, Integer.valueOf(numbers[i]));
            sum+= intNum.get(i);
        }
        System.out.println(intNum+" sum = "+sum);

//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }
        scanner.close();

    }
}
