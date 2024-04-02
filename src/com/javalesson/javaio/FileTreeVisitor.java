package com.javalesson.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileTreeVisitor {
    public static void main(String[] args) throws IOException {
    Path path = Paths.get("temp");
//    Files.walkFileTree(path, new Visitor());

        Files.walkFileTree(path, new CopyFileVisitor(path, Paths.get("temp2"+File.separator+"copy")));

    }

    public static class Visitor extends  SimpleFileVisitor<Path>{
        //Метод возвращает все файлы по указанному пути
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            int nameCount = file.getNameCount(); //количество вложенных директорий (относительно)
            Path firstPath = file.subpath(0, nameCount - 1);// первая часть пути (все директории)
            Path lastPath = file.subpath(nameCount - 1, nameCount);// вторая часть пути (название файла)
            //переименование файла с помощью метода move путем добавления в имя сегодняшней даты
            Files.move(file, Paths.get(firstPath+ File.separator+ LocalDate.now().format(DateTimeFormatter.ISO_DATE)+"_"+lastPath));
            System.out.println(nameCount);
            return FileVisitResult.CONTINUE;
        }

        //Метод возвращает все директории по указанному пути
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//            System.out.println(dir);
            return FileVisitResult.CONTINUE;
        }
    }

    public static class CopyFileVisitor extends SimpleFileVisitor<Path> {
        Path source;
        Path destination;

        public CopyFileVisitor(Path source, Path destination) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
            try {
                copy(path);
            }catch (IOException e){
                System.out.println("Ошибка копирования" +path);
                e.printStackTrace();
                return  FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        private void copy(Path path) throws IOException {
            Path relative = source.relativize(path);
            System.out.println("относительный путь" + relative);
            Path destinationPath = destination.resolve(relative);
            System.out.println("Destination path" + destinationPath);
            Files.copy(path, destinationPath);
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            try {
                copy(path);
            }catch (IOException e){
                System.out.println("Ошибка копирования файла" +path);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Ошибка копирования" + file);
            return FileVisitResult.CONTINUE;
        }
    }
}

