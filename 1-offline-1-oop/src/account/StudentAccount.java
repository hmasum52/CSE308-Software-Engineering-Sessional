package account;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import util.Util;

public class StudentAccount extends Account {

    public StudentAccount(String name, double initialDeposit)
            throws InvalidAmountException {
        super(name, AccountType.STUDENT, initialDeposit);
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
            throw new InvalidAmountException("Invalid transaction! Amount should be greater than 0$");
        }
        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        if (amount > 10000) {
            throw new InvalidAmountException("Invalid transaction; current banalce is " + Util.toMoneyString(balance));
        }

        this.balance -= amount;
    }

    @Override
    public void requestLoan(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid transaction! Amount should be greater than 0$");
        }

        if (amount > 1000) {
            throw new InvalidAmountException(
                    "Invalid transaction; maximum allowable loan is 1,000$ for student account");
        }

        this.balance += amount;
        this.loan += amount;
    }
}
