package exception;

public class PermissionDeniedException extends BankException {
    public PermissionDeniedException() {
        super("You don't have permission for this operation");
    }
}
