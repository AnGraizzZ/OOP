package javatests.test.object;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 100000)
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());

        User a = new User(){
            void test(){
                System.out.println('b');
            }
        };
        a.test();


    }
}

class User {
void test(){
        System.out.println("a");
    }
}

