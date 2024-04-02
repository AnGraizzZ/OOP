package com.javalesson.nasledovanie;

public abstract class PetrolAuto extends Auto{
    private int availablePetrol;
    private int tankVolume;

    public PetrolAuto(String firma, String model, Engien engien, int availablePetrol, int tankVolume) {
        super(firma, model, engien);
        this.availablePetrol = availablePetrol;
        this.tankVolume = tankVolume;
    }

    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public void fuelUp(int petrolVolume){
        availablePetrol+=petrolVolume;
        System.out.println("В баке "+availablePetrol+" литров");
    }
}
