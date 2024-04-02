package com.javalesson.collections.autoboxing;

import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {
                 List<Double> list = new LinkedList<>();
                 list.add(1.4);
         list.add(1.0);

         Integer chislo = 45;
         int n = chislo.intValue();

         String[] colors = {"yellow","green","blue"};
         LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(colors));
         linkedList.add("black");
         colors = linkedList.toArray(new String[linkedList.size()]);
         for (int i=0; i<colors.length;i++)
         {
             System.out.println(colors[i]);
         }
    }
}
