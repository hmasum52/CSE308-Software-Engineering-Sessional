package exception;

public class InsufficientBalanceException extends BankException {
    public InsufficientBalanceException(String message) {
        super("Invalid amount. " +message);
    }
}
