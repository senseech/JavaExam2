import java.util.*;

public class HeroNMonsters {
    public static void main(String[] args) {

        int lvlHero = 1;
        int hurtHero = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Количество монстров");
        int numOfMonsters = in.nextInt();

        System.out.println("уровни монстров");
        ArrayList<Integer> lvlMonsters = new ArrayList<>();
        for (int i = 0; i < numOfMonsters; i++){
            lvlMonsters.add(i, in.nextInt());
        }
        in.close();

        lvlMonsters.sort(Integer::compare);

        for (int i =0; i < numOfMonsters; i++){
            if (lvlHero >= lvlMonsters.get(i)){
                if (lvlMonsters.get(i)*2 > lvlHero){
                    hurtHero++;
                }
                lvlHero++;
            }
            else {
                System.out.println("GG уровень монстра" + i);
                break;
            }
            if (hurtHero == 3){
                lvlHero--;
                hurtHero = 0;
            }
            if (i == numOfMonsters - 1){
                System.out.println("Вин уровень монстра" + i);
            }
        }
    }
}
