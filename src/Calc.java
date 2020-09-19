import java.io.IOException;
import java.util.Scanner;

public class Calc {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double x = in.nextDouble();
        System.out.print("Введите второе число: ");
        double y = in.nextDouble();
        System.out.print("Введите вид операции (+ | - | * | /): ");
        char operation = (char) System.in.read();

        double result = calc(x, y, operation);

        if (y == 0 && operation == '/') System.out.println("На 0 делить нельзя (но это не точно) " + Double.NaN);
        else System.out.println("Результаты расчета: " + result);

    }

    static double calc(double x, double y, char operation) {
        
        switch (operation) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/': return x / y;
            default:
                System.out.println("Введите корректную операцию \"+ | - | * | /\""); return Double.NaN;
        }

    }

}
