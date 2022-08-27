public class RealRootSolver extends EquationSolver {

    @Override
    public void solve(double a, double b, double c) {
        double temp = b*b - 4*a*c;
        if(temp > 0){
            System.out.println("Real roots of the equation " + a + "*x^2 + " + b + "*x + " + c + " are: "); 
            double x1 = ( -b + Math.sqrt(temp) )/(2*a);
            System.out.println("x1: "+x1);
            double x2 = (-b - Math.sqrt(temp)) /(2*a);
            System.out.println("x2: "+x2);
        }else{
            if(next!=null)
                next.solve(a, b, c);
        }
    }
    
}
