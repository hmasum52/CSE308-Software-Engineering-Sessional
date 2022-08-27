import java.util.Scanner;

public class Main{
    static EquationSolver getSolver(){
        EquationSolver real = new RealRootSolver();
        EquationSolver single = new SingleRootSolver();
        EquationSolver imaginary = new ImaginaryRootSolver();

        real.setNext(single);
        single.setNext(imaginary);

        return real;
    }

    public static void main(String[] args) {
        EquationSolver solver = getSolver();

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nQuadratic equations are of form a*x^2 + b*x + c");
            System.out.print("Enter a, b, c to solve a equation: ");

            double a,b,c;
            
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();

            solver.solve(a, b, c); 
        }
    }
}