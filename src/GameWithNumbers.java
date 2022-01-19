import java.util.ArrayList;
import java.util.Scanner;

public class GameWithNumbers {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Количество цифр");
        int conOfNumbers = in.nextInt();

        System.out.println("Введи цифры");
        ArrayList<Integer> arrOfNumbers = new ArrayList<>();
        for (int i = 0; i < conOfNumbers; i++) {
            arrOfNumbers.add(i, in.nextInt());
        }
        arrOfNumbers.add(conOfNumbers, 0);
        in.close();

        System.out.println(CheckArray(arrOfNumbers));

    }

    static ArrayList CheckArray(ArrayList<Integer> arrayList) {
        int repeatNum = 0;
        int oldRepeatNum = arrayList.get(arrayList.size() - 1);
        ArrayList<Integer> subList = new ArrayList<>();
        subList = (ArrayList<Integer>) arrayList.clone();

        for (int i = 0; i < arrayList.size() - 2; i++) {
            if (arrayList.get(i) == arrayList.get(i + 1)) {
                repeatNum++;
                if ((i == arrayList.size()-3) & (repeatNum >= 2)){
                    arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) + repeatNum + 1);
                    subList = (ArrayList<Integer>) arrayList.clone();
                    subList.subList(i - repeatNum + 1, i + 2).clear();
                }
            } else if ((arrayList.get(i) != arrayList.get(i + 1))) {
                if (repeatNum >= 2) {
                    arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) + repeatNum + 1);
                    subList = (ArrayList<Integer>) arrayList.clone();
                    subList.subList(i - repeatNum, i + 1).clear();
                    break;
            }
                repeatNum = 0;
        }
        }

        if (oldRepeatNum == arrayList.get(arrayList.size() - 1)){
            return subList;
        }

        return CheckArray(subList);
    }
}


