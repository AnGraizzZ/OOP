package com.javapluslesson.graph;
//обход графа
public class MyStack {
    private  int size = 10; // размер стека
    private  int top; // верхний элемент стека (элементы кладутся в стопку снизу вверх)
    private int[] array; // массив хранения самого стека

    public MyStack() {
        top = -1; // так как массив начинается с нуля, соответственно пустой стек обозначается как -1
        array = new int[size]; // задаем размер стека
    }
    //метод занесения узла
    public void push(int v){
        array[++top]=v;
    }
    // метод удаления вершины
    public int pop(){
        return array[top--];
    }
    // метод извлечения вершины (просмотра)
    public int peek(){
        return array[top];
    }

    //метод проверки стека на пустоту
    public  boolean isEmpty(){
        if(top==-1)
            return true;
        else
            return false;
    }




}
