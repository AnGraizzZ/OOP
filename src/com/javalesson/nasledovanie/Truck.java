package com.javalesson.nasledovanie;

public class Truck extends PetrolAuto {
    private int cargoWeight;

    @Override
    public void energize() {
        fuelUp(getTankVolume()-getAvailablePetrol());
    }

    public Truck(String firma, String model, Engien engien, int availablePetrol, int tankVolume, int cargoWeight) {
        super(firma, model, engien, availablePetrol, tankVolume);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void load(){
        System.out.println("Cargo loaded");
    }
    public void unload(){
        System.out.println("Cargo unloaded");
    }
}
