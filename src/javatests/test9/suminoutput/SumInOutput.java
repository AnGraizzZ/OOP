package javatests.test9.suminoutput;

import javatests.test8.inoutout.SendClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SumInOutput {

    public static void main(String[] args) throws FileNotFoundException {
        // универсальный разделитель директорий
        String separator = File.separator;
        // получаем расположение файла данного класса
        String paths = "src" + separator + SumInOutput.class.getPackageName().replace(".", separator) + separator;
        //получаем путь до файла input.txt
        File file = new File(paths + "input.txt");
        //включаем инструмент сканирования для файла input
        Scanner scanner = new Scanner(file);
        //получаем данные из первой строки
        String data = scanner.nextLine();
        //получаем путь до файла output.txt
        File fileOut = new File(paths + "output.txt");
        //включаем инструмент записи для файла output
        PrintWriter writer = new PrintWriter(fileOut);
        //записываем в файл
        writer.println(sumMethod(data));
        //закрываем и сохраняем файл
        writer.close();
    }

        public static int sumMethod (String string){
            //Разделяем строку по пробелу и записываем в массив
            String[] arrSum = string.split(" ");
            int sum = 0;
            for (String s : arrSum) {
                //переводим строки в числа и складываем
                sum += Integer.parseInt(s);
            }
            return sum;
        }

}
