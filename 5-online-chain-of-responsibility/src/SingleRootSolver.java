public class SingleRootSolver extends EquationSolver {

    @Override
    public void solve(double a, double b, double c) {
        double temp = b * b - 4 * a * c;
        if (temp == 0) {
            System.out.println("Single root of the equation "+a+"*x^2 + "+b+"*x + "+c+" is: ");
            double x = -b / (2*a);
            System.out.println("x = "+x);
        } else {
            if(next != null)
                next.solve(a, b, c);
        }
    }
    
}
