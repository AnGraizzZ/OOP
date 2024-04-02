package com.javalesson.collections.StackQueue;

import java.util.Stack;

public class StackQueueLauncher {
    public static void main(String[] args) {
        passengerProcessing();
    }

    private static void passengerProcessing() {
        Stack<Passenger> bus = new Stack<>();
        Passenger passenger = new Passenger("Benedict ", "Cumberbatch");
        bus.push(new Passenger("Kira", "Naitli"));
        bus.push(new Passenger("Gusein", "Gasanov"));
        bus.push(new Passenger("Dmitriy", "Medvedev"));
        bus.push(passenger);
        bus.push(new Passenger("Bill", "Geits"));
        System.out.println("Последний пассажир " + bus.peek());
        System.out.println("Пассажир " + passenger + " находится на позиции №" + bus.search(passenger) + " от выхода");
        System.out.println("Встретились как то в автобусе");
        while (!bus.empty()) {
            System.out.println(bus.pop());
        }

    }

    private static class Passenger {
        private static int number = 1;
        private String name;
        private String surname;

        public Passenger(String name, String surname) {
            number++;
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return " пассажир " + name + " " + surname;
        }
    }

}
