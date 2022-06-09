import java.util.Scanner;

import qms.QMSBuilder;
import qms.QMSDirector;
import qms.QMSFactory;
import qms.QueueManagementSystem;

/**
 * @author Hasan Masum(1805052)
 */
public class SalesApp {
    public static void main(String[] args) {
        System.out.println("Sales app launched...");
        Scanner scanner = new Scanner(System.in);

        // director build Queue Management System
        QMSDirector director = new QMSDirector();

        while (true) {
            try {

                /// ============= The name of the Queue Management System ============
                System.out.println("\nAvailable Queue Management System:");
                System.out.println("Deluxe: LCD panel with Raspberry Pi");
                System.out.println("Optimal: Arduino Mega with LED matrix");
                System.out.println("Poor: ATMega32 with LED matrix");
                System.out.print("\nEnter your choice(ex: delux): ");
                String type = scanner.nextLine();
                System.out.print("Enter Display price: ");
                double displayPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter number of display units: ");
                int displayNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Processor price: ");
                double processorPrice = scanner.nextDouble();
                scanner.nextLine();
            
                /// ============  communication channel input =======================
                System.out.print("\nEnter communication system name(wifi/sim): ");
                String internetType = scanner.nextLine();
                System.out.print("Enter communication module price: ");
                double communicationModulePrice = scanner.nextDouble();
                scanner.nextLine();

                
                // ============== controller app price and yearl communication cost ==============
                System.out.print("\nEnter controller app price: ");
                double controllerAppPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter yearly communication cost: ");
                double yearlyCommunicationCost = scanner.nextDouble();
                scanner.nextLine();

                // ============== create QMSBuilder object ======================
                QMSBuilder builder = QMSFactory.getQmsBuilder(type);

                // =============== making Queue Management System ===============
                director.buildQMS(builder, internetType, displayNumber);
                QueueManagementSystem qms = builder.getQMS();

                // =============== set the price of products ===================
                qms.setDisplayPrice(displayPrice)
                        .setProcessorPrice(processorPrice)
                        .setCommunicationModulePrice(communicationModulePrice)
                        .setControllerAppPrice(controllerAppPrice)
                        .setYearlyComunicationCost(yearlyCommunicationCost);

                // show description of Queue Management System
                // with total cost calculation
                qms.showCashMemo();

                System.out.print("Want to buy another one? (y/n): ");
                String answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("y")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        scanner.close();
    }

}
