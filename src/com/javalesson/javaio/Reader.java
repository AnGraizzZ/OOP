package com.javalesson.javaio;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public void readFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String resRead;
        while ((resRead = bufferedReader.readLine()) != null) {
            System.out.println(resRead);

        }
        reader.close();
    }

    public List<Student> readObjects(String fileName) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            boolean keepRead = true;
            while (keepRead) {
                Student student = (Student) in.readObject();
                if (!"".equals(student.getName())) {
                    students.add(student);
                } else {
                    keepRead = false;
                }

            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public void readFileInFull(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String l : lines) {
            System.out.println(l);
        }
    }

    public void nioReadFileWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8"); //указание кодировки файла
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public void nioReadWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (InputStream in = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public void nioReadWithChannel(String fileName) throws IOException {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw"); //класс  для работы с файлом с определенными разрешениями
        FileChannel channel = file.getChannel(); // работа с файлом с помощью канала
        ByteBuffer buffer = ByteBuffer.allocate(100); //выделяем буфер 100 байт
        int bytesNumber = channel.read(buffer); // читаем из выделенного буфера с помощью канала
        byte b;
        char c;
        while (bytesNumber > 0) {// пока буфер больше нуля
            buffer.flip();// перенос каретки
            while (buffer.hasRemaining()) {
                b= buffer.get();
                c= (char) b;
                System.out.print(c);
            }
            buffer.clear();
            bytesNumber = channel.read(buffer);
        }
    }
}
