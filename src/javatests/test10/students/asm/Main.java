package javatests.test10.students.asm;

public class Main {
    public static void main(String[] args) {
        int[] zadachi = {45,30,20,10};
        Student st1 = new Student(1,zadachi.length,zadachi);
        Student st3 = new Student(3,zadachi.length,zadachi);
        Student st5 = new Student(5,zadachi.length,zadachi);

        if(st1.rezultat()>=st3.rezultat()||st1.rezultat()>=st5.rezultat()){
            System.out.println(1);
        }else{
            if(st3.rezultat()>=st5.rezultat()){
                System.out.println(3);
            }else{
                System.out.println(5);
            }
        }
    }
}
