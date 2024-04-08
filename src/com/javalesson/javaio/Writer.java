package com.javalesson.javaio;

import com.javalesson.collections.map.treemap.StudentGrade;
import com.javalesson.collections.map.treemap.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Writer {
    public void writeFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите данные в следующем виде: clientID, clientName, clientFirstName, balance");
        int i = 0;
        while (i < 3) {
            try {
                formatter.format("%d, %s, %s, %.2f%n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода, повторите попытку:");
                scanner.nextLine();
            }
        }
        formatter.close();
    }
    public void writeFile(SortedMap<StudentGrade, Set<SubjectGrade>> grades, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        try (PrintWriter writer = new PrintWriter(fileWriter)) {

            for (StudentGrade gradeKey : grades.keySet()) {
                writer.write("_________________________\n");
                writer.write("Студент: " + gradeKey.getName() + " Средняя оценка: " + gradeKey.getOcenka() + "\n");
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Предмет: " + grade.getSubject() + " Оценка: " + grade.getGrade() + "\n");
                }
            }
        }
    }

    public void  writeObject(List<Student> students, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            for (Student student: students){
                out.writeObject(student);
            }
            out.writeObject(new Student("", -1, null));
        }catch (IOException e){
            System.out.println("Невозможно открыть файл");
            e.printStackTrace();
        }
    }

    public  void nioWriteWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(fileName, 5,2);//(текст, от какого символа, до какого символа)
        }
    }

    public void nioWriteWithStream(String fileName) throws  IOException{
        Path path = Paths.get(fileName);
        String text = "Возможно открыть файл";
        byte[] bytes = text.getBytes();
        try(OutputStream stream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            stream.write(bytes,0,bytes.length);
        }
    }

    public void nioWriteWithChannel(String fileName) throws IOException {
        String str = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
                "Aenean commodo ligula eget dolor. Aenean massa. " +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
                "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.";
        RandomAccessFile file = new RandomAccessFile(fileName, "rw"); //класс для работы с файлом с определенными разрешениями
        FileChannel channel = file.getChannel(); // работа с файлом с помощью канала
        ByteBuffer buffer = ByteBuffer.allocate(str.getBytes().length);
        byte[] bytes = str.getBytes();
        buffer = ByteBuffer.wrap(bytes);
        channel.write(buffer);
        channel.close();
    }

    public void writeWithRandomAccess(String fileName) throws IOException {
        ByteBuffer mark = ByteBuffer.wrap(" MARKED AREA ".getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(10);
        Path path = Paths.get(fileName);
        try (FileChannel  openFile = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE)){
            int numBytes = 0;
            while (buffer.hasRemaining() && numBytes!=-1){
                numBytes = openFile.read(buffer);
            }
            openFile.position(0);
            openFile.write(mark);
            long size = openFile.size();
            openFile.position(size/2);
            mark.rewind();
            openFile.write(mark);
            openFile.position(size-1);
            mark.rewind();
            openFile.write(mark);
            buffer.rewind();
            openFile.write(buffer);


        }

    }
}
