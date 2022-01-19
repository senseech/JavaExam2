import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.abs;

public class MapTracker {
    public ArrayList<TowerParam> arrOfTowers = new ArrayList<>();
    public ArrayList<ArrayList <Integer>> pathOfTowers = new ArrayList<>();
    public ArrayList<Integer>  walkingWay = new ArrayList<>();
    public int startTower, finishTower;

    void addTower(int x, int y, int r){
        TowerParam towerParam = new TowerParam();
        towerParam.X = x;
        towerParam.Y = y;
        towerParam.R = r;
        arrOfTowers.add(towerParam);
    }

    boolean crossOfTowers(int firstTower, int secondTower,MapTracker mapTracker){
        return (abs(mapTracker.arrOfTowers.get(firstTower).X - mapTracker.arrOfTowers.get(secondTower).X) <=
                (mapTracker.arrOfTowers.get(firstTower).R + mapTracker.arrOfTowers.get(secondTower).R + 1)) &
                (abs(mapTracker.arrOfTowers.get(firstTower).Y - mapTracker.arrOfTowers.get(secondTower).Y) <=
                        (mapTracker.arrOfTowers.get(firstTower).R + mapTracker.arrOfTowers.get(secondTower).R + 1)) &
                (firstTower != secondTower);
    }

    int crossOfPoint(int x, int y, MapTracker mapTracker){
        int check = -1;
        for (int i = 0; i < mapTracker.arrOfTowers.size(); i++) {
            if ((abs(mapTracker.arrOfTowers.get(i).X - x) <= mapTracker.arrOfTowers.get(i).R) &
                    (abs(mapTracker.arrOfTowers.get(i).Y - y) <= mapTracker.arrOfTowers.get(i).R)) {
                check = i;
            }
        }
        return check;
    }

    void CheckingPath(MapTracker mapTracker){
        for (int i = 0; i < mapTracker.arrOfTowers.size(); i++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < mapTracker.arrOfTowers.size(); j++){
                if (mapTracker.crossOfTowers(i, j,mapTracker) & (i != j)){
                    arrayList.add(j,j);
                }
                else {
                    arrayList.add(j,null);
                }
            }
            arrayList.removeIf(Objects ::isNull);
            mapTracker.pathOfTowers.add(arrayList);
        }
    }

    boolean SearchWay(MapTracker mapTracker){
        boolean check = false;
        for (int i = 0; i < mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).size(); i++) {
            if (mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i) == mapTracker.finishTower){
                return true;
            }
            else if (mapTracker.pathOfTowers.get(mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i)).size() == 0) {
                return false;
            }
            else if (mapTracker.pathOfTowers.get(mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i)).size() == 1) {
                mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).set(i,null);
            }
            else if ((mapTracker.pathOfTowers.get(mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i)).size() > 1) &
            !(mapTracker.walkingWay.contains(mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i)))){
                mapTracker.walkingWay.add(mapTracker.pathOfTowers.get(mapTracker.walkingWay.get(mapTracker.walkingWay.size() -1)).get(i));
            }
        }
        return SearchWay(mapTracker);
    }

    public static void main(String[] args) {

        MapTracker mapTracker = new MapTracker();
        mapTracker.addTower(2, 2,1);
        mapTracker.addTower(5, 5,2);
        mapTracker.addTower(9, 1,1);
        mapTracker.addTower(12,4,2);
        mapTracker.addTower(8, 9,1);

        mapTracker.CheckingPath(mapTracker);

        mapTracker.startTower = mapTracker.crossOfPoint(5,5,mapTracker);
        mapTracker.finishTower = mapTracker.crossOfPoint(9,9,mapTracker);

        //mapTracker.pathOfTowers.get(1).removeIf(Objects::isNull);

        if (mapTracker.startTower < 0 & mapTracker.finishTower < 0){
            System.out.println("Начало или конец пути все зоны вышки");
        }
        else {
            mapTracker.walkingWay.add(mapTracker.startTower);
            System.out.println(mapTracker.SearchWay(mapTracker));
        }
    }

    public class TowerParam{
        int X;
        int Y;
        int R;
    }

}
