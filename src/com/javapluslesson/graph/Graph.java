package com.javapluslesson.graph;
// класс создания графа
public class Graph {
    private  int maxN = 10; //максимально количество узлов графа
    private int[][] mas; // матрица смежности (наличие связи между узлами
    Vertex[] vertexList; //список узлов
    private  int curN; //счетчик количества узлов
    private MyStack stack = new MyStack();// инициализация стека

    //инициализация объектов
    public Graph() {
        vertexList = new Vertex[maxN];
        mas=new int[maxN][maxN];
        curN=0;
    }

    //метод создания узла
    public void  addVertex(char name){
        vertexList[curN++] = new Vertex(name);

    }
    //метод создания ребер
    public void addEdge(int start, int end, int val){ //переменная val позволяет создать путь если граф должен быть неориентированным
        mas[start][end]=1;
        mas[end][start]=val;
    }
//проверка существования смежной вершины и отсутствия ее посещения
    public int check (int v){
        for(int i=0; i< curN; i++){
            // если переменная хранящаяся в ячейке матрицы v/i равна 1 (связь есть) и
            // если визита в этот узел не было, то возвращаем в котором хранится этот узел
            if(mas[v][i]==1 && !vertexList[i].getIsVisited()){
                return i;
            }
        }
        //если после прохождения цикла не найдена связь, то возвращаем -1
        return -1;
    }
    //метод обхода в глубину
    public  void passInDeep(int index){
        System.out.println(vertexList[index].getName());// выводим первый узел
        vertexList[index].setIsVisited(true);// передаем значение посещения данного узла
        stack.push(index);// добавляем узел в стек
        while (!stack.isEmpty()){// если стек не пустой
            int sosed = check(stack.peek());//проверяем связь
            if(sosed == -1){
                sosed = stack.pop(); //если связи нет удаляем элемент из стека
            }else{//если есть, то выводим значение и добавляем элемент в стек
                System.out.println(vertexList[sosed].getName());
                vertexList[sosed].setIsVisited(true);
                stack.push(sosed);            }
        }
        for (int i=0; i<curN;i++){
            vertexList[i].setIsVisited(false);
        }
    }
}
