package com.javalesson.collections.map.treemap;

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {
        NavigableMap<StudentGrade, Set<SubjectGrade>> grades = createGrade();
        //printGrades(grades,false);
        StudentGrade borderGrades = grades.ceilingKey(new StudentGrade("", 80));
        NavigableMap<StudentGrade, Set<SubjectGrade>> stipendyStudents =
                (NavigableMap<StudentGrade, Set<SubjectGrade>>) grades.tailMap(borderGrades);
        printGrades(stipendyStudents.descendingMap(),false);
        System.out.println("Претендент");
        StudentGrade contender = grades.lowerKey(borderGrades);
        System.out.println(contender);
    }

    private static void printGrades(Map<StudentGrade, Set<SubjectGrade>> grades, boolean printValue){
        Set<StudentGrade> AVGrade = grades.keySet();
        for (StudentGrade gr: AVGrade){
            System.out.println(gr);
            if (printValue){
                System.out.println(grades.get(gr));
            }
        }
    }
    public static NavigableMap<StudentGrade, Set<SubjectGrade>> createGrade(){
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Математика",89));
        alexGrades.add(new SubjectGrade("Физика",65));
        alexGrades.add(new SubjectGrade("История",95));
        alexGrades.add(new SubjectGrade("Литература",90));
        alexGrades.add(new SubjectGrade("Химия",75));

        Set<SubjectGrade> jamseGrades = new HashSet<>();
        jamseGrades.add(new SubjectGrade("Математика",75));
        jamseGrades.add(new SubjectGrade("Физика",80));
        jamseGrades.add(new SubjectGrade("История",55));
        jamseGrades.add(new SubjectGrade("Литература",70));
        jamseGrades.add(new SubjectGrade("Химия",80));

        Set<SubjectGrade> antonyGrades = new HashSet<>();
        antonyGrades.add(new SubjectGrade("Математика",93));
        antonyGrades.add(new SubjectGrade("Физика",91));
        antonyGrades.add(new SubjectGrade("История",82));
        antonyGrades.add(new SubjectGrade("Литература",78));
        antonyGrades.add(new SubjectGrade("Химия",88));

        Set<SubjectGrade> victoriaGrades = new HashSet<>();
        victoriaGrades.add(new SubjectGrade("Математика",73));
        victoriaGrades.add(new SubjectGrade("Физика",65));
        victoriaGrades.add(new SubjectGrade("История",75));
        victoriaGrades.add(new SubjectGrade("Литература",66));
        victoriaGrades.add(new SubjectGrade("Химия",50));

        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alinaGrades.add(new SubjectGrade("Математика",75));
        alinaGrades.add(new SubjectGrade("Физика",67));
        alinaGrades.add(new SubjectGrade("История",78));
        alinaGrades.add(new SubjectGrade("Литература",69));
        alinaGrades.add(new SubjectGrade("Химия",57));

        NavigableMap<StudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new StudentGrade("Alex",calcAVG(alexGrades)),alexGrades);
        map.put(new StudentGrade("Jamse",calcAVG(jamseGrades)),jamseGrades);
        map.put(new StudentGrade("Antony",calcAVG(antonyGrades)),antonyGrades);
        map.put(new StudentGrade("Victoria",calcAVG(victoriaGrades)),victoriaGrades);
        map.put(new StudentGrade("Alina",calcAVG(alinaGrades)),alinaGrades);

        return map;
    }
    private static float calcAVG(Set<SubjectGrade> ocenki){
        float sum = 0f;
        for (SubjectGrade ocenka: ocenki){
            sum+=ocenka.getGrade();
        }
        return sum/ocenki.size();
    }
}
