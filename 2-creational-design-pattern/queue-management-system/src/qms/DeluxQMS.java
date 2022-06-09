package qms;

import display.LCDPanel;
import module.CommunicationModule;
import processor.RaspberryPi;
import webapp.ControllerApplication;

public class DeluxQMS implements QMSBuilder {
    private QueueManagementSystem qms;

    public DeluxQMS() {
        qms = new QueueManagementSystem("DELUX( LCD panel with Raspberry Pi )");
    }

    @Override
    public void addDisplay() {
        qms.setDisplay(new LCDPanel());
    }

    @Override
    public void addProcessor() {
        qms.setProcessor(new RaspberryPi());
    }

    @Override
    public void addControllerApplication() {
        qms.setControllerApp(new ControllerApplication());
    }

    @Override
    public void addCommunciationSystem(String type) throws Exception {
        qms.setComunicationModule(new CommunicationModule(type));
    }

    @Override
    public void addDisplayUnitNumber(int number) {
        qms.setDisplayUnits(number);
    }

    @Override
    public QueueManagementSystem getQMS() {
        return qms;
    }

}
