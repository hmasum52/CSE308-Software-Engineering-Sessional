package module.internet;

public class SimCard implements InternetModule{
    private double price;

    @Override
    public String getModuleName() {
        return "Sim card";
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
