package qms;

/**
 * factory class for creating {@link QMSBuilder} instance
 */
public class QMSFactory {
    public static QMSBuilder getQmsBuilder(String type) throws Exception {
        switch (type.toUpperCase()) {
            case QMSBuilder.DELUX:
                return new DeluxQMS();
            case QMSBuilder.OPTIMAL:
                return new OptimalQMS();
            case QMSBuilder.POOR:
                return new PoorQMS();
            default:
                throw new Exception("Unknown option");
        }
    }
}
