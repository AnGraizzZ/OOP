package com.javalesson.domainmodel;

public class Empl {
    private static int id;
    private int emplId;
    private String name;
    private  String position;
    private int zp;
    private String department;

    public Empl() {
        this("a", "b", 1);
        System.out.println("Empty constructor called");
    }

    public Empl(String name, String position, int zp){
        new Empl(name, position, zp, "IT");
        System.out.println("Constructor with 3 params called");
    }

    public Empl(String name, String position, int zp, String department) {
        emplId = ++id;
        this.name = name;
        this.position = position;
        this.zp = zp;
        this.department = department;
        System.out.println("Constructor with 4 params called");
    }

    public int getEmplId() {
        return emplId;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getZp() {
        return zp;
    }

    @Override
    public String toString() {
        return "Empl{" +
                "emplId=" + emplId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", zp=" + zp +
                '}';
    }
}
