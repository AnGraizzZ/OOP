package com.javalesson.collections.map.treemap;

public class StudentGrade implements Comparable<StudentGrade>{
    private final String name;
    private final float ocenka;

    public StudentGrade(String name, float ocenka) {
        this.name = name;
        this.ocenka  = ocenka;
    }

    public String getName() {
        return name;
    }

    public float getOcenka() {
        return ocenka;
    }

    @Override
    public int compareTo(StudentGrade that) {
        if(this.ocenka <that.getOcenka()){
            return -1;
        }if(this.ocenka >that.getOcenka()){
            return 1;
        }
        return name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "name='" + name + '\'' +
                ", ocenka=" + ocenka +
                '}';
    }
}
