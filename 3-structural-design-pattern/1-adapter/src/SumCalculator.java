import java.io.File;
import java.util.Scanner;
/**
 * adaptee class
 */
public class SumCalculator {
    public void calculateSum(String fileName) throws Exception  {
        Scanner scanner = new Scanner(new File(fileName));
        int sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        System.out.println("Sum of numbers in file  is = "+ sum);
        scanner.close();
       // return sum;
    }
}
