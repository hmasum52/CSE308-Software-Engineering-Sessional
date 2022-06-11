package qms;

import display.Display;
import module.CommunicationModule;
import processor.Processor;
import webapp.Application;

/**
 * Product: Queue Management System
 */
public class QueueManagementSystem {

    // Deluxe: LCD panel with Raspberry Pi
    // Optimal: Arduino Mega with LED matrix
    // Poor: ATMega32 with LED matrix
    private String type;
    private Display display;
    private Processor processor;

    // The communication system for communication between the display unit and controller application
    private CommunicationModule comunicationModule;

    // number of display units
    private int displayUnits;

    // application
    private Application controllerApp;

    public QueueManagementSystem(String type) {
        this.type = type;
    }

    public QueueManagementSystem(Display display, Processor processor,
            CommunicationModule comunicationModule,
            int displayUnits, Application controllerApp) {
        this.processor = processor;
        this.display = display;
        this.comunicationModule = comunicationModule;
        this.displayUnits = displayUnits;
        this.controllerApp = controllerApp;
    }

    // ================= GETTER SETTTERS =================

    public String getType() {
        return type;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Display getDisplay() {
        return display;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setComunicationModule(CommunicationModule comunicationModule) {
        this.comunicationModule = comunicationModule;
    }

    public CommunicationModule getComunicationModule() {
        return comunicationModule;
    }

    public void setDisplayUnits(int displayUnits) {
        this.displayUnits = displayUnits;
    }

    public int getDisplayUnits() {
        return displayUnits;
    }

    public void setControllerApp(Application controllerApp) {
        this.controllerApp = controllerApp;
    }

    public Application getControllerApp() {
        return controllerApp;
    }

    // ============== PRICE ==============

    public QueueManagementSystem setDisplayPrice(double price) {
        this.display.setPrice(price);
        return this;
    }

    public QueueManagementSystem setProcessorPrice(double price) {
        this.processor.setPrice(price);
        return this;
    }

    public QueueManagementSystem setYearlyComunicationCost(double yearlyCost) {
        this.comunicationModule.setYearlyCost(yearlyCost);
        return this;
    }

    public QueueManagementSystem setCommunicationModulePrice(double price){
        this.comunicationModule.getInternetModule().setPrice(price);
        return this;
    }
    public QueueManagementSystem setControllerAppPrice(double price) {
        this.controllerApp.setPrice(price);
        return this;
    }

    // ============== CASHMEMO ===============
    public void showCashMemo() {
        System.out.println();        
        System.out.println("============================================");
        System.out.println("Queue Management System:" + type);
        System.out.println("Communication system: " + comunicationModule.getInternetModule().getModuleName());
        System.out.println("Processor price: " + processor.getPrice());
        System.out.println("Display price "+"(x"+displayUnits+"): "+ (display.getPrice()*displayUnits));
        System.out.println("Communication module price: "+comunicationModule.getInternetModule().getPrice());
        System.out.println("Application cost: " + controllerApp.getPrice());
        System.out.println("Communication system yearly cost: " + comunicationModule.getYearlyCost());
        System.out.println("---");
        System.out.println("Total cost: " + getTotalCost());
        System.out.println("============================================");
        System.out.println();
    }

    public double getTotalCost() {
        double cost = display.getPrice() * displayUnits;
        cost += processor.getPrice();
        cost += comunicationModule.getYearlyCost();
        cost += comunicationModule.getInternetModule().getPrice();
        cost += controllerApp.getPrice();
        return cost;
    }
}
