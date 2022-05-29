package account;

import java.util.Date;

import exception.BankException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import util.Util;

public class FixedDepositeAccount extends Account {

    public FixedDepositeAccount(String name, double initialDeposit)
            throws InvalidAmountException {
        super(name, AccountType.FIXED_DEPOSITE, initialDeposit);
        if (initialDeposit < 100000)
            throw new InvalidAmountException("Invalid Amount! Minimum amount should be 100,000$");
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 50000) {
            throw new InvalidAmountException("Invalid Amount! Minimum amount should be at least 50,000$");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount)
            throws BankException {

        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        }

        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        int days = Util.diffInDays(createDate, new Date(System.currentTimeMillis()));

        if (days < 365) {
            throw new BankException("Account has not reached a maturity period of one year.");
        }

        this.balance -= amount;
    }

    @Override
    public void requestLoan(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid transaction! Amount should be greater than 0$");
        }

        if (amount > 100000) {
            throw new InvalidAmountException(
                    "Invalid transaction; maximum allowable loan is 100,000$ for student account");
        }

        this.balance += amount;
        this.loan += amount;
    }



}
