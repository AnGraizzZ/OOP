package com.javalesson.Interface;

public class Pizza  implements Priceble{
    private String name;
    private int quantity;
    private int price;
    private Size size;

    public Pizza(String name, int quantity, int price, Size size) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    @Override
    public int calcDeliverPrice() {
        if(size == Size.XL || quantity > 1)
            return 0;
        else {
            return 7;
        }
    }

    @Override
    public int calcOrderPrice() {
        return quantity*price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }
}
