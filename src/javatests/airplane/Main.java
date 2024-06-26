package javatests.airplane;

class OuterClass {
    void outerMethod() {
        int num = 25;

        class LocalClass {
            void display() {
                System.out.println("Число: " + num);
            }
        }

        LocalClass local = new LocalClass();
        local.display();
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}