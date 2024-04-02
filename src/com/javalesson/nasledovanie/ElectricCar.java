package com.javalesson.nasledovanie;

public class ElectricCar extends Auto {
    public ElectricCar(String firma, String model, EngienType engienType) {
        super(firma, model, engienType);
        System.out.println("Машина инициализирована");
    }
}
