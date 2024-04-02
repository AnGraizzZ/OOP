package com.javalesson.nasledovanie;

public class Bus extends PetrolAuto {
    private int passagerNumber;

    @Override
    public void energize() {
        fuelUp(getTankVolume()-getAvailablePetrol());
    }
    public Bus(String firma, String model, Engien engien, int availablePetrol, int tankVolume, int passagerNumber) {
        super(firma, model, engien, availablePetrol, tankVolume);
        this.passagerNumber = passagerNumber;
    }

    public int getPassagerNumber() {
        return passagerNumber;
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Автобус поехал");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Автобус остановился");
    }

    public void setPassagerNumber(int passagerNumber) {
        this.passagerNumber = passagerNumber;
    }

    public void pickUpPass(int passNum){
        passagerNumber+=passNum;
        System.out.println("В автобусе стало"+passagerNumber+"пассажиров");
    }

    public void releasePass(){
        if(isRunning) {
            stop();
        }
        passagerNumber = 0;
        System.out.println("Конечная, все пассажиры вышли");
    }

    /*public void fuelUp(){
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);
    }*/

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePetrol()+petrolVolume;
        if (volume>getTankVolume()){
            setAvailablePetrol(getTankVolume());
        }
        System.out.println("Заправка Дизелем");
    }
}
