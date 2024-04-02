package com.javalesson.oop;


public class Main {
    public static void main(String[] args) {
        Dog mops = new Dog();
        mops.setLapki(4);
        mops.setPoroda("Мопс");
        mops.setHvost(1);
        mops.setName("Глобус");
        mops.setSize(Size.MEDIUM);  
        mops.bite();

        Dog boss = new Dog();
        boss.setName("Босс");
        boss.bite();

        Dog chihuaAhua = new Dog();
        chihuaAhua.setName("Пикчер");
        chihuaAhua.setHvost(1);
        chihuaAhua.setLapki(4);
        chihuaAhua.setPoroda("Чихуа Ахуа");
        chihuaAhua.setSize(Size.LITTLE);
        chihuaAhua.bite();

        Size s = Size.UNDEFINED;

        Size[] values = Size.values();
        for (int i=0; i<values.length; i++){
            System.out.println(values[i]);
        }
    }
}

