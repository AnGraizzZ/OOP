package javatests.test8.inoutout;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Scanner;

public class SendClass {
    public static void main(String[] args) throws IOException {
        // универсальный разделитель директорий
        String separator = File.separator;
        // получаем расположение файла данного класса
        String paths = "src"+separator+SendClass.class.getPackageName().replace(".",separator)+separator;
        //получаем путь до файла input.txt
        File file = new File(paths+"input.txt");
        //включаем инструмент сканирования для файла input
        Scanner scanner = new Scanner(file);
        //получаем данные из первой строки
        String money = scanner.nextLine();
        //получаем путь до файла output.txt
        File fileOut = new File(paths+"output.txt");
        //включаем инструмент записи для файла output
        PrintWriter writer = new PrintWriter(fileOut);
        //записываем в файл
        writer.println(money);
        //закрываем и сохраняем файл
        writer.close();
    }
}
