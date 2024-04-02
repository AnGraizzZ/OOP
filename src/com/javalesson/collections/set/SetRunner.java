package com.javalesson.collections.set;

import java.util.*;

public class SetRunner {
    public static void main(String[] args) {
        Set<Car> rusCars = new HashSet<>();
        rusCars.add(new Car("VAZ","2109",1200));
        rusCars.add(new Car("VAZ","2114",1100));
        rusCars.add(new Car("Lada","Kalina",1000));
        rusCars.add(new Car("Lada","Granta",2200));
        rusCars.add(new Car("Lada","Priora",2000));

        Set<Car> japanCars = new HashSet<>();
        japanCars.add(new Car("Lada","Priora",2000));
        japanCars.add(new Car("Toyota","Camry",3300));
        japanCars.add(new Car("Honda","Civic",2200));
        japanCars.add(new Car("Mitsubishi","Lancer",1100));
        japanCars.add(new Car("Nissan","Note",3000));

//        rusCars.removeAll(japanCars)
        NavigableSet<Car> unitCars = new TreeSet<>(rusCars);
        unitCars.addAll(japanCars);// получаем объеденение;
        SortedSet<Car> tailToCars = unitCars.subSet(
                new Car("Honda","Civic",2200), false,
                new Car("Toyota", "Camry", 3300), true);
        print(unitCars);
        System.out.println();
        System.out.println("higher");
        System.out.println(unitCars.higher(new Car("Nissan","Note",3000)));
        System.out.println("lower");
        System.out.println(unitCars.lower(new Car("Nissan","Note",3000)));
        System.out.println("ceiling");
        System.out.println(unitCars.ceiling(new Car("Nissan","Note",3000)));


    }

    private static void print(Set<Car>cars){
        System.out.printf("%-20s %-20s %-20s","Car brand", "model", "Price per Day");
        for (Car car:cars){
            System.out.println();
            System.out.printf("%-20s %-20s %s руб. ",car.getCarBrand(), car.getModel(), car.getPricePerDay());        }
    }
}
