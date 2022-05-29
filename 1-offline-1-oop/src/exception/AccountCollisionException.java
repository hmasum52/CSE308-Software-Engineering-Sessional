package exception;

public class AccountCollisionException extends BankException {
    public AccountCollisionException(){
        super("Account already exists!");
    }
}
