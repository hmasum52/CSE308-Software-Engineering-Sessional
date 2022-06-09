package qms;

import display.LEDMatrix;
import module.CommunicationModule;
import processor.ArduinoMega;
import webapp.ControllerApplication;


public class OptimalQMS implements QMSBuilder {
    private QueueManagementSystem qms;

    public OptimalQMS() {
        qms = new QueueManagementSystem("OPTIMAL(Arduino Mega with LED matrix)");
    }

    @Override
    public void addDisplay() {
        qms.setDisplay(new LEDMatrix());
    }

    @Override
    public void addProcessor() {
        qms.setProcessor(new ArduinoMega());
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
