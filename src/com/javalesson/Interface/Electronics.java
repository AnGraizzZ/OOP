package com.javalesson.Interface;

public abstract class Electronics implements Priceble{
    private String make;
    private String model;
    private int quantity;
    private int price;

    public Electronics(String make, String model, int quantity, int price) {
        this.make = make;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public int calcOrderPrice() {
        return getQuantity()*getPrice();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
