package com.javalesson.innerclasses;

public class Main {
    public static void main(String[] args) {
        CellPhone phone = new CellPhone("Samsung","A32");// объект телефона
        phone.turnOn();//иниц дисплея
        phone.call("1234567890");
    }
}
