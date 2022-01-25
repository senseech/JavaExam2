import java.util.Scanner;

public class MedyanSV {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arrOfNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            arrOfNumbers[i] = in.nextInt();
        }
        in.close();
        boolean[] flag = new boolean[3];
        flag[0] = false;
        flag[1] = false;
        flag[2] = false;

            if ((arrOfNumbers[0] >= arrOfNumbers[1]) & (arrOfNumbers[0] <= arrOfNumbers[2])) {
                flag[0] = true;
            }
            if ((arrOfNumbers[0] >= arrOfNumbers[2]) & (arrOfNumbers[0] <= arrOfNumbers[1])) {
                flag[0] = true;
            }
            if ((arrOfNumbers[1] >= arrOfNumbers[0]) & (arrOfNumbers[1] <= arrOfNumbers[2])) {
                flag[1] = true;
            }
            if ((arrOfNumbers[1] >= arrOfNumbers[2]) & (arrOfNumbers[1] <= arrOfNumbers[0])) {
                flag[1] = true;
            }
            if ((arrOfNumbers[2] >= arrOfNumbers[0]) & (arrOfNumbers[2] <= arrOfNumbers[1])) {
                flag[2] = true;
            }
            if ((arrOfNumbers[2] >= arrOfNumbers[1]) & (arrOfNumbers[2] <= arrOfNumbers[0])) {
                flag[2] = true;
            }

        if ((flag[0]) & (flag[1]) & (flag[2])){
            System.out.println("YES");
            System.out.println("YES");
            System.out.println("YES");
        }

        int[] sortArrOfNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sortArrOfNumbers[j] = arrOfNumbers[j];
            }
            for (int j = 0; j < 3; j++){
                if (i!=j) {
                    sortArrOfNumbers[i] = sortArrOfNumbers[i] - sortArrOfNumbers[j];
                    if ((sortArrOfNumbers[0] >= sortArrOfNumbers[1]) & (sortArrOfNumbers[0] <= sortArrOfNumbers[2])) {
                        flag[0] = true;
                    }
                    if ((sortArrOfNumbers[0] >= sortArrOfNumbers[2]) & (sortArrOfNumbers[0] <= sortArrOfNumbers[1])) {
                        flag[0] = true;
                    }
                    if ((sortArrOfNumbers[1] >= sortArrOfNumbers[0]) & (sortArrOfNumbers[1] <= sortArrOfNumbers[2])) {
                        flag[1] = true;
                    }
                    if ((sortArrOfNumbers[1] >= sortArrOfNumbers[2]) & (sortArrOfNumbers[1] <= sortArrOfNumbers[0])) {
                        flag[1] = true;
                    }
                    if ((sortArrOfNumbers[2] >= sortArrOfNumbers[0]) & (sortArrOfNumbers[2] <= sortArrOfNumbers[1])) {
                        flag[2] = true;
                    }
                    if ((sortArrOfNumbers[2] >= sortArrOfNumbers[1]) & (sortArrOfNumbers[2] <= sortArrOfNumbers[0])) {
                        flag[2] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (flag[i]){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}












