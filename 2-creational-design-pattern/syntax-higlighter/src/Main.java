/**
 * @author Hasan Masum(1805052)
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Editor editor = Editor.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fileName: ");
        try {
            while (scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                System.out.println();
                editor.openFile(fileName);
                System.out.print("\nEnter a fileName: ");
            }
        } catch (Exception e) {
            System.out.println("Invalid fileName");
        }

        scanner.close();
    }
}
