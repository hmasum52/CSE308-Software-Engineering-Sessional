package processor;

public class ArduinoMega implements Processor {
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
