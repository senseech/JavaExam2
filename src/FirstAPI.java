import java.util.*;
public class FirstAPI {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        cities.stream() // получаем поток
                .filter(s->s.length()==6) // применяем фильтрацию по длине строки
                .forEach(s->System.out.println(s)); // выводим отфильтрованные строки на консоль
    }
}