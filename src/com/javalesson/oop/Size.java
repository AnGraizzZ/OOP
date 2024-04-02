package com.javalesson.oop;

public enum Size {
    LITTLE("L"), MEDIUM("M"), BIG("B"), UNDEFINED("");

    Size(String abr){
        this.abr = abr;
    }
    private String abr;

    public String getAbr() {
        return abr;
    }
}
