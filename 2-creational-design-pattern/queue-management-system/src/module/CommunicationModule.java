package module;

import module.internet.InternetModule;
import module.internet.InternetModuleFactory;

public class CommunicationModule {
    private double yearlyCost;
    private InternetModule internetModule;

    public CommunicationModule(String type) throws Exception {
        internetModule = InternetModuleFactory.getInternetModule(type);
    }

    public void setYearlyCost(double yearlyCost) {
        this.yearlyCost = yearlyCost;
    }

    public void setInternetModule(InternetModule internetModule) {
        this.internetModule = internetModule;
    }

    public double getYearlyCost() {
        return yearlyCost;
    }

    public InternetModule getInternetModule() {
        return internetModule;
    }
}
