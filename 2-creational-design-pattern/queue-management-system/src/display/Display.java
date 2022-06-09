package display;

public interface Display {
    static final String LEDMATRIX = "LEDMATRIX";
    static final String LCDPANEL = "LCDPANEL";
    void setPrice(double price);
    double getPrice();
}
