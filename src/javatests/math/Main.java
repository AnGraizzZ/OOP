package javatests.math;

public class Main {
    public static void main(String[] args) {
        MathInterface sum = (a,b) -> a - b;
        System.out.println(sum.operation(4,5));
    }
}
