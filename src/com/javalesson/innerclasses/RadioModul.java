package com.javalesson.innerclasses;

public class RadioModul {
    public RadioModul() {
        System.out.println("радиомодуль включен");
    }

    public void call(String number){
        int dlinna = 10;
        class GSMModule{
            private String phoneNuber;
            private int validNumber;
            public GSMModule(String phoneNumber) {
                this.phoneNuber = phoneNumber;
            }
            public boolean isValid() {
                if (phoneNuber.length() != dlinna) {
                    return false;
                }else
                {
                    try {
                        validNumber = Integer.parseInt(phoneNuber);
                        return true;
                    } catch (NumberFormatException e){
                        return false;
                    }
                }

            }
            public void dialIn(){
                if(isValid()){
                    System.out.println("Звоним на номер " + validNumber);
                }else {
                    System.out.println("Неверные номер телефона");
                }
            }
        }
        GSMModule module = new GSMModule(number);
        module.dialIn();
    }
}
