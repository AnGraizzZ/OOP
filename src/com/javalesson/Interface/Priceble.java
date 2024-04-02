package com.javalesson.Interface;

public interface Priceble extends Deliverable, Orderable{
    default int calcPrice(){
        return calcOrderPrice()+calcDeliverPrice();
    }

    static void doSmth(){

    }
}
