import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * adapter class to which connects {@link SumCalculator} and
 * {@link TildaSumCalculator}
 */
public class SumAdapter implements TildaSumCalculator { // Target

    // adaptee
    private SumCalculator sumCalculator;

    public SumAdapter(String fileSaparator){
        sumCalculator = new SumCalculator();
    }

    @Override
    public int calculateSum(String fileName) throws Exception {
        String tempFileName = createTempFile(fileName);
        int sum = sumCalculator.calculateSum(tempFileName);
        deleteTempFile(tempFileName);
        return sum;
    }

    private String createTempFile(String fileName) throws Exception {
        
        Scanner scanner = new Scanner(new File(fileName));
        String s = scanner.nextLine();
        s = s.replace("~", " ");

        String tempFileName = fileName + ".tmp";
        File tempFile = new File(tempFileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(s);
        writer.close();

        scanner.close();
        return tempFileName;
    }

    private void deleteTempFile(String fileName) {
        File tempFile = new File(fileName);
        tempFile.delete();
    }
}
