package com.javalesson.streams;

import com.javalesson.lambdas.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOverviewMain {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap=null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee(1, "Alex","Black", 50000, "IT"));
        employeeList.add(new Employee(2, "John","Green", 75000,"BUH"));
        employeeList.add(new Employee(6, "Pavel","Brown", 80000, "IT"));
        employeeList.add(new Employee(9, "Anna","Grey", 90000, "IT"));
        employeeList.add(new Employee(10, "Vadim","Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Valeria","Pink", 750000,"BUH"));
        employeeList.add(new Employee(16, "Connor","Magenta", 80000,"BUH"));
        employeeList.add(new Employee(19, "Sergei","Black", 88000, "IT"));
        employeeList.add(new Employee(9, "Irina","Gray", 90000, "IT"));
        employeeList.add(new Employee(10, "Maxim","Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Valeria","Black", 75000,"BUH"));
//        testStreamFromList();
       // testStreamFromFile();
//        testSortAndReduce();
//        partitionByIncome();
//        groupCriterion(Employee::getDepartment);
//        testStreamGeneration(7);
//        testStreamIterator(5);
//        testParallelStream();
        Supplier<Integer> supplier = new Supplier<Integer>() {
            private  int previous = 0;
            private int current = 1;

            @Override
            public Integer get() {
                int next = previous +current;
                previous = current;
                current = next;
                return current;
            }
        };

        testStreamGeneration(20, supplier);


    }


    private static void testParallelStream() throws IOException {
        employeeList.parallelStream()
                .map(Employee::getId)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Files.lines(Paths.get("words.txt"))
                .parallel()
                .sorted();
    }
    private static void testStreamIterator(int limit){
        Stream.iterate(1, e->e*2).limit(limit).forEach(System.out::println);
    }
    private static <T> void testStreamGeneration(int limit, Supplier<T> supplier){
        Stream.generate(supplier)
                .limit(limit).forEach(System.out::println);
    }
    private static <R> void groupCriterion(Function<Employee, R> function){
        Map<R, List<Employee>> collectEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(function));

        collectEmployees.keySet().stream().forEach(e-> System.out.println(e+"\n"+collectEmployees.get(e)));
    }
    private static void partitionByIncome(){ //разделение объектов по определенному признаку
        Map<Boolean, List<Employee>> collectEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));
        System.out.println("Низакая ЗП");
        System.out.println(collectEmployees.get(false));
        System.out.println("\n Высокая ЗП");
        System.out.println(collectEmployees.get(true));
    }

    private static void testSortAndReduce(){
        /*Employee employee = employeeList.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).get();
        System.out.println(employee);
        Employee employee1 = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getSalary)).get();
        System.out.println(employee1);*/
        employeeList.stream()
                .sorted((s1,s2)->s1.getFirstName().compareTo(s2.getFirstName()))
                .distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

       /* Employee defEmployee = new Employee(0,"","",0); //начальный Employee
        Employee reduceEmployee = employeeList.stream()
                .reduce(defEmployee, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;
                });
        System.out.println(reduceEmployee);*/



    }
    private static void testStreamFromList(){
        Integer[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
//        employeeList.stream()
//                .filter(x->x.getSalary()>60000)
//                .filter(x->x.getId()<10)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        Stream.of(ids)
//                .map(StreamsOverviewMain::findById)
//                .collect(Collectors.toList())
//                .stream().filter(x->x!=null)
//                .forEach(System.out::println);
        int sum = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .sum();
       // System.out.println(sum);
        Stream.of(ids)
                .peek(e->e=e*2).
                filter(e->e<3)
                .forEach(System.out::println);
//        int zero = 0;
//        Stream.of(ids)
//                .forEach(e->zero=zero+e);

    }
    private static void testStreamFromFile() throws IOException{
        try {


            Files.lines(Paths.get("words.txt"))//указание файла с текстом
                    .filter(e -> e.length() > 4)//фильтр по словам длинна которых больше 4
                    .map(String::toUpperCase)//делаем все буквы заглавными
                    .distinct()//исключаем повторяющиеся слова
                    .sorted()//сортируем слова в алфавитном порядке
                    .forEach(System.out::println);//выводим на экран
        }catch (IOException e){
            System.out.println("Файл не существует");
        }
    }
    private static Employee findById(int id){
        if(employeeMap==null){
           employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId,e->e));
        }
        return employeeMap.get(id);
    }
}
