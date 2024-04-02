package com.javalesson.nasledovanie;

public class ElectricCar extends Auto {
    private int batteryVolume;
    private int passagerNumber;

    @Override
    public void energize() {
        charge();
    }

    public ElectricCar(String firma, String model, int batteryVolume, int passagerNumber) {
        super(firma, model, new Engien());
        this.batteryVolume = batteryVolume;
        this.passagerNumber = passagerNumber;
    }

    private void charge(){
        System.out.println("Батарея заряжается");
    }

    public int getBatteryVolume() {
        return batteryVolume;
    }

    public void setBatteryVolume(int batteryVolume) {
        this.batteryVolume = batteryVolume;
    }

    public int getPassagerNumber() {
        return passagerNumber;
    }

    public void setPassagerNumber(int passagerNumber) {
        this.passagerNumber = passagerNumber;
    }
}
