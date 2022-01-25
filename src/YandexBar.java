
import java.util.ArrayList;
import java.util.Scanner;

class Liquor{
    String nameLiquor;
    String amountOfLiquor;
    String charOfLiquor;
}

public class YandexBar {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int heightOfCup = in.nextInt();
        int widthOfCup = in.nextInt();

        String[] imageCup = new String[heightOfCup];

        imageCup[0] = in.nextLine();
        for (int i = 0; i < heightOfCup; i++){
                imageCup[i] = in.nextLine();
        }



        int numOfDrinks = in.nextInt();
        ArrayList<Liquor> arrOfLiq = new ArrayList<>(numOfDrinks);
        for (int i = 0; i < numOfDrinks; i++) {
            Liquor liquor = new Liquor();
            liquor.nameLiquor = in.next();
            liquor.amountOfLiquor = in.next();
            liquor.charOfLiquor = in.next();
            arrOfLiq.add(liquor);
        }

        in.close();
        int count = 0;
        int numOfCurDrink = 0;
        int layersOfCurDrink = Integer.parseInt(arrOfLiq.get(0).amountOfLiquor.trim());


        for (int i = 0; i < arrOfLiq.size(); i++){
            count = count + Integer.parseInt(arrOfLiq.get(i).amountOfLiquor.trim());
        }

        String[] imageFullCup = new String[heightOfCup];
        for (int i = 0; i < heightOfCup; i++) {
            imageFullCup[i] = imageCup[i];
        }

        for (int i = heightOfCup - 2; i >= heightOfCup - count - 1; i--){
            if ((layersOfCurDrink == 0) & (numOfCurDrink < numOfDrinks)){
                numOfCurDrink++;
                layersOfCurDrink = Integer.parseInt(arrOfLiq.get(numOfCurDrink).amountOfLiquor.trim());
            }

            if(numOfCurDrink == numOfDrinks){
                break;
            }

            char charLiq = arrOfLiq.get(numOfCurDrink).charOfLiquor.charAt(0);
            imageFullCup[i] = imageCup[i].replace(' ', charLiq);
            layersOfCurDrink--;




        }


        for (int i = 0; i < heightOfCup; i++){
            System.out.println(imageFullCup[i]);
        }



    }
}
