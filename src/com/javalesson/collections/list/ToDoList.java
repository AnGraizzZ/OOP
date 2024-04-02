package com.javalesson.collections.list;

import java.util.*;

public class ToDoList {
    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String task){
//        toDoList.add(task); //добавление нового элемента в ТуДуЛист
        addInAlphabet(task);
    }
    private boolean addInAlphabet(String task){
        ListIterator<String> stringListIterator = toDoList.listIterator();
        while (stringListIterator.hasNext()){
            int compareTo = stringListIterator.next().compareTo(task);
            if(compareTo == 0){
                System.out.println("Задача уже есть в списке");
                return true;
            }else if(compareTo>0){
                stringListIterator.previous();
                stringListIterator.add(task);
                return true;
            }

        }
        stringListIterator.add(task);
        return true;
    }
    public  void addToListAtPosition (int position, String task){
        if (position > toDoList.size() || position < 0)
        {
            position=toDoList.size();
            System.out.println("Произошел выход за пределы, программа автоматически назначила задаче номер "+position);
        }
        toDoList.add(position,task); //Добавление элемента в определенной позиции туду листа
    }

    public void printToDoList(){
//        for (int i=0;i<toDoList.size();i++){ //вывод значений туду листа на экран
//            System.out.println(i+" - "+toDoList.get(i));
//        }

        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()){
            System.out.println("Элемент "+iterator.next());
        }

    }

    public void changeTask (int index, String task){
        toDoList.set(index, task);//Замена элемента в определенной позиции туду листа
    }

    public void removeTask (String task){
        toDoList.remove(task);//Удаление элемента из туду листа
    }
    public int getPriority (String task){
        return toDoList.indexOf(task); //получение индекса задачи туду листа
    }

}
