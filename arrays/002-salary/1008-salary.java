import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int id = sc.nextInt();
        int workedHours = sc.nextInt();
        double valuePerHour = sc.nextDouble();
        
        double salary = valuePerHour * workedHours;
        
        System.out.println("NUMBER = " + id);
        System.out.printf("SALARY = U$ %.2f", salary);
    }
 
}