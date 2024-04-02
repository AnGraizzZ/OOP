package com.javalesson.nasledovanie;

public abstract class Auto {
    private String firma;
    private String model;
    private Engien engien;
    private int currentSpeed;
    protected boolean isRunning;

    public abstract void energize();
    public Auto(String firma, String model, Engien engien) {
        this.firma = firma;
        this.model = model;
        this.engien = engien;
        System.out.println("Автомобиль инициализирован");
    }

    public void start(){
        isRunning = true;
        currentSpeed=10;
        System.out.println("Машина поехала");

    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void stop(){
        isRunning = false;
        currentSpeed = 0;
        System.out.println("Машина остановилась");
    }

    public void  accelerate(int kmofh){
        currentSpeed+=kmofh;
        System.out.println("Скорость машины "+currentSpeed+"km/h");
    }
    public String getFirma() {
        return firma;
    }

    public String getModel() {
        return model;
    }

    public Engien getEngien() {
        return engien;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
