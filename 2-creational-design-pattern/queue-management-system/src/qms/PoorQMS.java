package qms;

import display.LEDMatrix;
import module.CommunicationModule;
import processor.ATMega32;
import webapp.ControllerApplication;

public class PoorQMS implements QMSBuilder {

    private QueueManagementSystem qms;

    public PoorQMS() {
        qms = new QueueManagementSystem("POOR(ATMega32 with LED matrix)");
    }

    @Override
    public void addDisplay() {
        qms.setDisplay(new LEDMatrix());
    }

    @Override
    public void addProcessor() {
        qms.setProcessor(new ATMega32());
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
