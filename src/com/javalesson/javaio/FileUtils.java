package com.javalesson.javaio;

import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
    public void printNioFileDetails(String fileName) throws IOException {
        Path path = Paths.get(fileName);//хранит название файла как путь
        Path path1 = FileSystems.getDefault().getPath(fileName);
        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Имя файла " + path.getFileName());
        System.out.println("Корневая директория " + absolutePath.getRoot());
        System.out.println("Абсолютный путь " + absolutePath);
        System.out.println("Родительская директория " + absolutePath.getParent());
        System.out.println("Количество имен в пути " + absolutePath.getNameCount());
        System.out.println("Вывести определенный диапазон имен пути " + absolutePath.subpath(0, 3));
        // Преобразовать любой путь в absolutePath
        Path path3 = Paths.get("../../");
        System.out.println("Абсолютный путь пути path3 " + path3.toRealPath());
        System.out.println("Файл существует? " + Files.exists(path));
        System.out.println("Файл не существует? " + Files.notExists(path));
        System.out.println("Можно ли читать файл? " + Files.isReadable(path));
        System.out.println("Можно ли запустить этот файл (исполняемый ли он)? " + Files.isExecutable(path));
        System.out.println("Эквивалентны ли эти файлы? " + Files.isSameFile(path, path1));
        Path parentPath = absolutePath.getParent(); // создание переменной с абсолютным путем
        Path filePath = parentPath.resolve("files");//Объединяет абсолютный путь в переменной parentPath с относительным путем в скобках
        if (Files.notExists(filePath)) {//проверяем отсутствие директории
            Files.createDirectory(filePath);//создаем директорию
        }
        System.out.println("test" + absolutePath);
        // Копирование
        //Files.move(absolutePath, filePath.resolve(path));
        Files.delete(filePath.resolve(path));
        Files.delete(filePath);
    }
    public void processDir() throws IOException {
        Path dir = Paths.get("temp");
        if (Files.notExists(dir)) {//проверяем отсутствие директории
            Files.createDirectory(dir);//создание папки с нозванием указанным в переменной dir в относительном расположении
        }
        Files.createDirectories(Paths.get("temp/A/G/z/z/Z"));//создание директорий в относительном расположении
        Files.createTempDirectory(dir, "tmp"); //создание временной директории с префиксом и случайными цифрами в названии
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();// массив логических дисков системы
        int ch = 0;
        for (Path rDir : rootDirectories) {
            System.out.println(rDir);
        }
        Path rrDir = Paths.get("E:\\");
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(rrDir)) {//содержит массив с названиями файлов и папок указанной директории
            for (Path p : paths) {
                //System.out.println(p);
            }
        }
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(rrDir, "*.{jpg,txt}")) {//содержит массив с названиями файлов указанных расширений
            for (Path p : paths) {
                // System.out.println(p);
            }
        }
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry); //фильтр по директориям
            }
        };
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(rrDir, filter)) {//содержит массив папок и файлов подходящих под фильтр
            for (Path p : paths) {
                System.out.println(p);
            }
        }
    }
}
