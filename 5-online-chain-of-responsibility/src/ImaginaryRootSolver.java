
public class ImaginaryRootSolver extends EquationSolver{

    @Override
    public void solve(double a, double b, double c) {
        double temp = b * b - 4 * a * c;
        if (temp < 0) {
            System.out.println("Imaginary roots of the equation " + a + "*x^2 + " + b + "*x + " + c + " are: ");
            double realPart = -b/(2*a);
            double imaginaryPart = Math.sqrt(-temp)/(2*a);
            System.out.println("x1 = "+realPart+" + "+imaginaryPart+"i");
            System.out.println("x2 = "+realPart + " - "+imaginaryPart+"i");
        }else {
            if(next != null)
                next.solve(a, b, c);
        }
    }
    
}
