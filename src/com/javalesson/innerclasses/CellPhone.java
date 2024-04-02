package com.javalesson.innerclasses;

public class CellPhone {
    private String make;
    private String model;
    private Display display;
    private RadioModul gsm;
    private AbstrPhoneBut button;

    public interface AbstrPhoneBut{
        void click();
    }
    public CellPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void turnOn(){
        initDisplay();
        gsm =new RadioModul();
        initButton();
    }

    public void initButton(){
        button = new AbstrPhoneBut() {
            @Override
            public void click() {
                System.out.println("Кнопка нажата");
            }
        };
    }
    public void call(String number){
        button.click();
        gsm.call(number);
    }
    private void initDisplay(){
        display = new Display();
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Display getDisplay() {
        return display;
    }
}
