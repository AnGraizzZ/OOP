package com.javalesson.constructors;


import com.javalesson.domainmodel.Empl;

import java.util.Date;

public class ConstructorsMain {
    public static void main(String[] args) {

        Empl e = new Empl("Paul", "Junior", 23_000);
        Empl e1 = new Empl("Dgek", "Junior", 23_000);
        System.out.println(e);
        System.out.println(e1);
    }
}
