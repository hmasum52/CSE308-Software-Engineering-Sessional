package qms;

/**
 * Director class to build Queue Management System.
 */
public class QMSDirector {
    public void buildQMS(QMSBuilder builder, String internetType, int displayNumber) throws Exception{
        // build Queue Management System
        builder.addDisplay();
        builder.addProcessor();
        builder.addControllerApplication();
        builder.addCommunciationSystem(internetType);
        builder.addDisplayUnitNumber(displayNumber);
    }
}
