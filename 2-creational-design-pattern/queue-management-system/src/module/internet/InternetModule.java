package module.internet;

public interface InternetModule {
    static final String WIFI = "WIFI";
    static final String SIM = "SIM";

    String getModuleName();
    void setPrice(double yearlyCost);
    double getPrice();
}
