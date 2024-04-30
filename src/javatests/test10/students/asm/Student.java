package javatests.test10.students.asm;

import java.util.Arrays;

public class Student {
    private int kurs;
    private int kol;
    private int[] zadachi = new int[kol];

    public Student(int kurs, int kol, int[] zadachi) {
        this.kurs = kurs;
        this.kol = kol;
        this.zadachi = zadachi;
    }

    public int rezultat(){
        int sumTime = 0;
        int sumZadach = 0;
        int sum=0;
        if(kurs == 1){
            Arrays.sort(zadachi);
            for (int i = 0; i < zadachi.length; i++){
                if(sumTime+zadachi[i]<=300){
                    sumTime+=zadachi[i];
                    sumZadach+=1;
                }
                if(sumTime>300){
                    break;
                }
            }
            sum=20000+(sumZadach*1000)-sumTime;
        } else if (kurs == 3){
                for (int i=zadachi.length-1; i>=0;i--){
                    if(sumTime+zadachi[i]<=300){
                        sumTime+=zadachi[i];
                        sumZadach+=1;
                    }
                    if(sumTime>300){
                        break;
                    }
                }
            sum=10000+(sumZadach*1000)-sumTime;
        } else if (kurs == 5){
            for (int i = 0; i < zadachi.length; i++){
                if(sumTime+zadachi[i]<=300){
                    sumTime+=zadachi[i];
                    sumZadach+=1;
                }
                if(sumTime>300){
                    break;
                }
            }
            sum=(sumZadach*1000)-sumTime;
        }else{
            System.out.println("Номер курса не соответствует условиям");
        }

        return sum;
    }


}
