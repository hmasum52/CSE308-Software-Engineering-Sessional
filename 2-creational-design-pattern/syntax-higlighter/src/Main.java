import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = Editor.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fileName: ");
        while(scanner.hasNextLine()){
            
            String fileName = scanner.nextLine();
            System.out.println();
            editor.openFile(fileName);
            System.out.print("\nEnter a fileName: ");
        }
        scanner.close();
    }
}
