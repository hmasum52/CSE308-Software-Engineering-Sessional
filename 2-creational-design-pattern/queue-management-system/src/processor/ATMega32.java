package processor;

/**
 * @author Hasan Masum(1805052)
 */
public class ATMega32 implements Processor {
    private double price;
    
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}
