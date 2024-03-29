package webapp;
/**
 * An application to control the display units over the internet
 */
public class ControllerApplication implements Application{
    private double price;

    public ControllerApplication() {
        price = 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
