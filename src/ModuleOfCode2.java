import java.util.Scanner;

public class ModuleOfCode2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] maxVModule = new int[3];
        for (int i = 0; i < maxVModule.length; i++) {
            maxVModule[i] = in.nextInt();
        }

        int numOfRules = in.nextInt();

        int[][] arrOfRules = new int[numOfRules][4];

        for (int i = 0; i < numOfRules; i++){
            for (int j = 0; j < 4; j++) {
                arrOfRules[i][j] = in.nextInt();
            }
        }
        in.close();

        //int[] curVModule = new int[3];

        boolean flag = false;
        int flagRules = 0;
        int counterV = 0;
        for (int i = 1; i <= maxVModule[2]; i++){
            for (int j = 1; j <= maxVModule[1]; j++){
                for (int k = 1; k <= maxVModule[0]; k++){
                    int[] curVModule = {k, j, i};
                    flagRules = numOfRules;
                    for (int l = 0; l < numOfRules; l++) {
                        flag = false;
                        if (curVModule[arrOfRules[l][0] - 1] >= arrOfRules[l][1]){
                            flagRules = 0;
                            if (curVModule[arrOfRules[l][2] - 1] >= arrOfRules[l][3]){
                                flag = true;
                            }
                            else {
                                flag = false;
                            }
                        }
                        if (flag){
                            flagRules++;
                        }
                    }
                    if (flagRules == numOfRules){
                        counterV++;
                    }



                }
            }
        }
        System.out.println(counterV);

    }
}
