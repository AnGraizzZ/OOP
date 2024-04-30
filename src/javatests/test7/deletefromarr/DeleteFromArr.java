package javatests.test7.deletefromarr;

public class DeleteFromArr {
    public static void main(String[] args) {
        int[] array = {3,4,22,5,3,8,22,10,22,13,3,22,55};
        int num = 22;
        int[] arrayCopy = new int[0];
        int check=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==num){
                arrayCopy=new int[array.length-1];
                for(int j=0;j<array.length-1;j++){
                    if(i>j){
                        arrayCopy[j]=array[j];
                    }else {
                        arrayCopy[j]=array[j+1];
                    }
                }
                array=arrayCopy;
            }
        }

        for(int a:array){
            System.out.println(a);
        }
    }
}
