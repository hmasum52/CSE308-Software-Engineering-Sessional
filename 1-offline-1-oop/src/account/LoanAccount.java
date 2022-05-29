package account;

import exception.InvalidAmountException;
import exception.PermissionDeniedException;

public class LoanAccount extends Account {

    public LoanAccount(String name, double initialDeposit)
            throws InvalidAmountException {
        super(name, AccountType.LOAN, initialDeposit);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        }

        if (this.loan < amount) {
            throw new InvalidAmountException("Invalid transaction! Amount is more than remaining loan!");
        }

        this.loan -= amount;

    }

    /**
     * A loan account cannot withdraw any amount from the account.
     */
    @Override
    public void withdraw(double amount)
            throws PermissionDeniedException {
        throw new PermissionDeniedException();
    }

    /**
     * The loan account holders can apply for additional 5% of the current loan amount.
     */
    @Override
    public void requestLoan(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        }

        if (this.balance * .05 != amount) {
            throw new InvalidAmountException("Invalid transaction! Amount is not equal to 5% of the current loan!");
        }

        this.loan += amount;
    }

}
