package com.javalesson.nasledovanie;

import java.util.List;

public class Nasled {
    public static void main(String[] args) {

        Engien tEngine = new Engien(6.0, EngienType.DISEL, 400);
        Truck gruzovik = new Truck("MAN","811",tEngine, 300, 500, 10);

        Auto tesla = new ElectricCar("tesla","5",400,3);

        Engien busEngine = new Engien(3.0,EngienType.BENZIN,400);
        Bus gazel = new Bus("GAZ","gazel",busEngine,75,250,11);


        isCar(tesla);
        isCar(gazel);

    }
    private static void isCar(Auto auto){
        auto.start();
        auto.stop();
        auto.energize();
    }

}
