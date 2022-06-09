package module.internet;

public class InternetModuleFactory {
    public static InternetModule getInternetModule(String type) throws Exception {
        switch (type.toUpperCase()) {
            case InternetModule.WIFI:
                return new WifiModule();
            case InternetModule.SIM:
                return new SimCard();
            default:
                throw new Exception("Invalid communication type");
        }
    }
}
