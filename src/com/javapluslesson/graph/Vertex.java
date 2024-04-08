package com.javapluslesson.graph;
// класс создания узлов
public class Vertex {
    private char name; //имя узла
    private boolean isVisited; // посещен ли узел

    public char getName() {
        return name;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setIsVisited(boolean visited) {
        isVisited = visited;
    }

    //инициализация переменных
    public Vertex(char name) {
        this.name = name;
    }
}
