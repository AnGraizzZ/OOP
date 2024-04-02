package com.javalesson.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@FunctionalInterface
interface ElementProcessor <T extends Number>{
    Double process(T element);// это метод

}
public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i=1; i<=5;i++){
            integerList.add(i);
        }
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(8.6);
        doubleList.add(1.23);
        doubleList.add(4.13);
        doubleList.add(12.2);

//        processElements(integerList, x->Math.exp(x.doubleValue()));
//        processElements(doubleList, x->Math.exp(x.doubleValue()));
        String s = "Hello";
        Double d = 0.1234;
//        TransformUtils<Double> doubleTransformUtils = new TransformUtils<>();
//        doubleTransformUtils.transform(d, Math::sin);
//
//        TransformUtils<String> stringTransformUtils = new TransformUtils<>();
//        //лямбда
//        stringTransformUtils.transform(s,x->TransformUtils.exclaim(x));
//        // референс
//        stringTransformUtils.transform(s, TransformUtils::exclaim);
//
//        String sufix = "Pavel";
//        //Лямбда
//        stringTransformUtils.transform(s, x->x.concat(sufix));
//        // референс
//        System.out.println(stringTransformUtils.transform(sufix, s::concat));
//        System.out.println(stringTransformUtils.transform(s, String::toUpperCase));
//        System.out.println(stringTransformUtils.transform(s, String::new));
        LambdaScopeTest scopeTest = new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner inner = scopeTest.new LambdaScopeInner();
        inner.testScope(d);




    }
    private  static <T extends Number>  void processElements(List<T> integerList, ElementProcessor function){
        List<Double> doubleList = new ArrayList<>();
        for (T i:integerList){
            doubleList.add(function.process(i));
        }
        System.out.println(doubleList);    }
}
