package com.javalesson.collections.list;

import java.util.List;
import java.util.Scanner;

public class ListRunner {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        printOut();
        int param = scanner.nextInt();

        do {
            switch (param){
                case 1:
                    System.out.println("Введите задачу");
                    scanner.nextLine();
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Задача сохранена");
                    printOut();
                    param = scanner.nextInt();
                    break;
                case 2:
                    list.printToDoList();
                    printOut();
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Введите номер задачи которую нужно заменить");
                    scanner.nextLine();
                    int index3 = scanner.nextInt();
                    System.out.println("Введите задачу");
                    scanner.nextLine();
                    String task3 = scanner.nextLine();
                    list.changeTask(index3, task3);
                    System.out.println("Задача изменена");
                    printOut();
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Введите задачу которую нужно удалить");
                    scanner.nextLine();
                    String task4 = scanner.nextLine();
                    list.removeTask(task4);
                    System.out.println("Задача удалена");
                    printOut();
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Введите приоритетную задачу");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();

                    System.out.println("Задача "+list.getPriority(task5)+" стала приоритетной");
                    printOut();
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Введите позицию в которой должна стоять задача");
                    scanner.nextLine();
                    int index6 = scanner.nextInt();
                    System.out.println("Ведите задачу");
                    scanner.nextLine();
                    String task6 = scanner.nextLine();
                    list.addToListAtPosition(index6,task6);
                    printOut();
                    param = scanner.nextInt();
                    break;
                default:
                    param = 0;

            }
        }while (param!=0);

    }

    private static void printOut(){
        System.out.println("Выберите необходимую функцию. Нажмите:\n"
                +"1 для создания задачи\n"
                +"2 для вывода задач\n"
                +"3 для изменения задачи\n"
                +"4 для удаления задачи\n"
                +"5 выставить приоритет задачи\n"
                +"6 для добавления задачи в нужную позицию\n"
                +"0 для выхода\n"
                +"После выбора операции нажмите ENTER\n"
        );

    }
}
