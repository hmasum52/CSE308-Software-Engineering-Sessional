package qms;

/**
 * Queue Management System Builder.
 */
public interface QMSBuilder {
    static final String DELUX = "DELUX";
    static final String OPTIMAL = "OPTIMAL";
    static final String POOR = "POOR";

    void addDisplay();
    void addProcessor();
    void addControllerApplication();
    void addCommunciationSystem(String type) throws Exception;
    void addDisplayUnitNumber(int number);

    QueueManagementSystem getQMS();
}
