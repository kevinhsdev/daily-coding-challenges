import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();

        int years = days / 365;
        int remainingDaysAfterYears = days % 365;

        int months = remainingDaysAfterYears / 30;
        int remainingDays = remainingDaysAfterYears % 30;

        System.out.println(years + " ano(s)");
        System.out.println(months + " mes(es)");
        System.out.println(remainingDays + " dia(s)");

        sc.close();
    }

}