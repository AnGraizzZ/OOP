package com.javalesson.javaio;

import com.javalesson.collections.map.treemap.StudentGrade;
import com.javalesson.collections.map.treemap.SubjectGrade;
import com.javalesson.collections.map.treemap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {
    private static final String FILE_NAME = "GradeBook.txt";
    private static final String BUFF_NAME = "BUFF_NAME.txt";
    private static final String BINARY_FILE_NAME = "Students.bin";

    public static void main(String[] args) throws IOException {
        SortedMap<StudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrade();
        Writer writer = new Writer();
        Reader reader = new Reader();
       writer.writeFile(grades, FILE_NAME);
//       reader.readFile(FILE_NAME);
//        writeFile(grades);
//        readFile();
//        writer.writeFormatter();
//        processGrades(grades, writer, BINARY_FILE_NAME);
//        outputObjects(reader, BINARY_FILE_NAME);
//        FileUtils utils = new FileUtils();
//        //utils.printNioFileDetails(FILE_NAME);
//        reader.nioReadFileWithBuffer(FILE_NAME);
//        writer.nioWriteWithBuffer(BUFF_NAME);
//        reader.nioReadWithStream(FILE_NAME);
//        writer.nioWriteWithStream(BUFF_NAME);
//        reader.readFileInFull(FILE_NAME);
//        reader.nioReadWithChannel(FILE_NAME);
//        writer.nioWriteWithChannel(BUFF_NAME);
//        writer.writeWithRandomAccess(FILE_NAME);
        FileUtils fileUtils = new FileUtils();
        fileUtils.processDir();
    }

    private static void processGrades (SortedMap<StudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName){
        List<Student> students = new ArrayList<>();
        for (StudentGrade gradeKey: grades.keySet()){
            students.add(new Student(gradeKey.getName(), gradeKey.getOcenka(), grades.get(gradeKey)));
        }
        writer.writeObject(students, fileName);
    }

    private static void outputObjects(Reader reader, String fileName){
        List<Student> students = reader.readObjects(fileName);
        for (Student student: students){
            System.out.printf("%s, %.2f, %n", student.getName(), student.getAVG());
            System.out.println(student.getGrades());
        }
    }
}
