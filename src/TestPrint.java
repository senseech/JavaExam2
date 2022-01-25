import java.util.Scanner;

public class TestPrint {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Количество цифр");

        int conOfNumbers = in.nextInt();
        in.close();
        System.out.println(conOfNumbers);
        System.out.println("conOfNumbers");
    }
}
