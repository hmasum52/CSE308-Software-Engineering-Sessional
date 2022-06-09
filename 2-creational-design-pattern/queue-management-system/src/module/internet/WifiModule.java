package module.internet;

public class WifiModule implements InternetModule {
    private double price;

    @Override
    public String getModuleName() {
        return "Wifi";
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
