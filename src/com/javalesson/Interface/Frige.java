package com.javalesson.Interface;

public class Frige extends Electronics{
    public Frige(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliverPrice() {
        if (getPrice()>=300)
            return 0;
        else
            return 25;

    }


}
