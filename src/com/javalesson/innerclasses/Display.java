package com.javalesson.innerclasses;

public class Display {
    public final int DISPLAY_HEIGHT = 1920;
    public final int DISPLAY_WIDTH = 1280;
    private int x = 0;

    public Display(){
        Pixel pixel = new Pixel(10,10,Color.BLUE);
    }

    private class Pixel{
        private int x;
        private int y;
        private Color color;

        private Pixel(int x, int y, Color color) {
            if (x>0&&x<DISPLAY_WIDTH&&y>0&&y<DISPLAY_HEIGHT) {
                this.x = x;
                this.y = y;
                this.color = color;
                System.out.println("Создание пикселя "+color+" в координатах x="+x+" y="+y);
            } else {
                throw new IllegalArgumentException("Выход за границы экрана "+DISPLAY_HEIGHT+"X"+DISPLAY_WIDTH);
            }
        }

    }

    public enum Color{
        RED,GREEN,BLUE;
    }
}

