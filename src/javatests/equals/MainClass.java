package javatests.equals;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {


        EqualseClass one = new EqualseClass(1L, "names");
        EqualseClass two = new EqualseClass(1L, "name");
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());

        Set<EqualseClass> set = new HashSet<>();
        set.add(one);
        set.add(two);

        System.out.println(set.size());
    }
}
