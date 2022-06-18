public class AdapterDemoMain {
    public static void main(String[] args) {
        System.out.println("hello world");
        //SumCalculator sumCalculator = new SumCalculator();
        TildaSumCalculator sumCalculator = new SumAdapter("~");
        try{
            //String fileName = "3-structural-design-pattern/1-adapter/src/input.txt";
            String fileName = "3-structural-design-pattern/1-adapter/src/input-with-tilda.txt";
            sumCalculator.calculateSum(fileName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
