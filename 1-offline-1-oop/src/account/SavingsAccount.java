package account;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class SavingsAccount extends Account {

    public SavingsAccount(String name, double initialDeposit)
            throws InvalidAmountException {
        super(name, AccountType.SAVINGS, initialDeposit);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        }
        this.balance += amount;

    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        }

        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        if (this.balance < 1000) {
            throw new InsufficientBalanceException("Current balance is less than 1000!");
        }
    }

    @Override
    public void requestLoan(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid transaction! Amount should be greater than 0");
        }

        if (amount > 10000) {
            throw new InvalidAmountException(
                    "Invalid transaction; maximum allowable loan is 10,000$ for savings account");
        }

        this.balance += amount;
        this.loan += amount;
    }
}
