package com.javalesson.Interface;

public class CellPhone extends Electronics {
    public CellPhone(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliverPrice() {
        if (getPrice()>=150)
            return 0;
        else
            return 10;
    }


}
