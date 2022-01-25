import java.util.Scanner;

public class GuardianOfTower {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numOfPlates = in.nextInt();
        int numOfGuard = in.nextInt();

        int[] arrOfPlates = new int[numOfPlates];
        for (int i = 0; i < numOfPlates; i++) {
            arrOfPlates[i] = in.nextInt();
        }

        int[] arrOfGuard = new int[numOfGuard];
        for (int i = 0; i < numOfGuard; i++) {
            arrOfGuard[i] = in.nextInt();
        }

        in.close();

        bubbleSort(arrOfGuard);
        boolean[] arrOfBool = new boolean[arrOfGuard.length];

        for (int i = arrOfPlates.length - 1; i >= 0; i--){
            int temp = 0;
            if (i!= arrOfPlates.length){
                for (int j = i + 1; j < arrOfPlates.length; j++){
                    if (arrOfPlates[j] > temp){
                        temp = arrOfPlates[j];
                    }
                }
            }
            for (int j = arrOfGuard.length - 1; j >= 0; j--)
                if ((arrOfGuard[j] <= (arrOfPlates[i] - temp)) & (!arrOfBool[j])){
                    arrOfBool[j] = true;
                    break;
                }
        }
        int temp = 0;
        for (int i = 0; i < arrOfBool.length; i++){
            if (arrOfBool[i]){
                temp++;
            }
        }
        System.out.println(temp);



    }
    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
