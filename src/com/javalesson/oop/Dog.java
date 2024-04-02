package com.javalesson.oop;

public class Dog {
    public static int DogsCount = 0;
    private int lapki = 4;
    private int hvost = 1;
    private String name;
    private String poroda;
    private Size size = Size.UNDEFINED;

    public Dog(){
        DogsCount++;
        System.out.println(DogsCount);
    }

    public void bite(){
        if (DogsCount>=3){
            System.out.println("Собаки тебя покусали");
        }else{
            gav();
        }
    }

    public void gav(){
        switch (size){
            case BIG: System.out.println("RWAF");
            case MEDIUM: System.out.println("WAF");
            case LITTLE: System.out.println("AF");
            default: System.out.println("Размер собаки не определен");
        }

    }
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLapki() {
        return lapki;
    }

    public void setLapki(int lapki) {
        if (lapki<=4 && lapki >= 0){
            this.lapki = lapki;
        }

        else {
            System.out.println("У собаки не может быть "+lapki+" лап");
            System.out.println("Корректное значение от 0 до 4");
        }

    }

    public int getHvost() {
        return hvost;
    }

    public void setHvost(int hvost) {
        this.hvost = hvost;
    }

    public String getPoroda() {
        return poroda;
    }

    public void setPoroda(String poroda) {
        this.poroda = poroda;
    }
}
