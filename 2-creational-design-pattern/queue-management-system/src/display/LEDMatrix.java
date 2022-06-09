package display;

public class LEDMatrix implements Display {
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
