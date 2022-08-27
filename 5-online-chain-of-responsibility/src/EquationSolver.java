public abstract class EquationSolver {
   
    EquationSolver next;

    public void setNext(EquationSolver next){
        this.next = next;
    }

    public abstract void solve(double a, double b, double c);
}
