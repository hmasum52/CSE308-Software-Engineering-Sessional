package account;

import java.util.Date;
import exception.BankException;
import exception.InvalidAmountException;

public abstract class Account {
    // account owener username
    protected String userName;
    // current balance
    protected double balance;
    protected AccountType accountType;
    protected double loan;
    protected Date createDate;

    public Account(String name, AccountType accountType, double initialDeposit)  throws InvalidAmountException
    {
        if (initialDeposit < 0)
            throw new InvalidAmountException("Invalid Amount! Amount should be greater than 0");
        this.userName = name;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.loan = 0;

        createDate = new Date();
    }

    public String getName() {
        return userName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public double getLoan() {
        return loan;
    }

    public void applyYearlyInterest() {
        if(accountType != AccountType.LOAN){
            balance += balance * accountType.getInterestRate();
            if(balance > 500){
                balance -= 500; // deduct yearly service charge
            }
        }

        double interestOnLoan = loan * 0.1; // 10% interest for loan per year

        if(balance > interestOnLoan){ // if the user has enough money to pay the loan
            balance -= interestOnLoan; // deduct the interest from the balance
        }
        else{
            // else add the interest to the loan
            loan += interestOnLoan;
        }
    }

    abstract public void deposit(double amount) throws BankException;

    abstract public void withdraw(double amount)
            throws BankException;

    abstract public void requestLoan(double amount) throws BankException;

}
