package com.javalesson.nasledovanie;

import java.util.ArrayList;
import java.util.List;

public class Engien {
    private double volume;
    private EngienType engienType;
    private int power;
    private List<Piston> pistons = new ArrayList<>();

    public Engien() {

    }

    public Engien(double volume, EngienType engienType, int power) {
        this.volume = volume;
        this.engienType = engienType;
        this.power = power;
        for (int i=1; i<=4; i++)
            this.pistons.add(new Piston(0.2,i));
    }


    public double getVolume() {
        return volume;
    }

    public EngienType getEngienType() {
        return engienType;
    }

    public int getPower() {
        return power;
    }

    public List<Piston> getPistons() {
        return pistons;
    }
}
