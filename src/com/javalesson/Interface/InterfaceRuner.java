package com.javalesson.Interface;

public class InterfaceRuner {
    public static void main(String[] args) {
        Priceble pizza = new Pizza("Neopolitana", 1,20,Size.L);
        Priceble phone = new CellPhone("Nokia","3310",1,90);
        Priceble frige = new Frige("LG","e22",1,300);
        printDeliverPrice(pizza);
        printDeliverPrice(phone);
        printDeliverPrice(frige);
    }
    private static void printDeliverPrice(Priceble del){
        System.out.println("Delivery price "+del.calcDeliverPrice());
        System.out.println("Order "+del.calcOrderPrice()  );
    }
}
