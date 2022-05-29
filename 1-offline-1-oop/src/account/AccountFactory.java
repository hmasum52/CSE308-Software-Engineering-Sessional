package account;

import exception.InvalidAmountException;

public class AccountFactory {
    public Account createAccount(String name, String accountType, double initialDeposit)
            throws InvalidAmountException {
        switch (accountType) {
            case "Savings":
                System.out.println("Savings Account Created");
                return new SavingsAccount(name,initialDeposit);
            case "Student":
                System.out.println("Student Account Created");
                return new StudentAccount(name, initialDeposit);
            case "Loan":
                System.out.println("Loan Account Created");
                return new LoanAccount(name, initialDeposit);
            case "FixedDeposite":
                System.out.println("FixedDeposite Account Created");
                return new FixedDepositeAccount(name, initialDeposit);
            default:
                System.out.println("Invalid Account Type");
                return null;
        }
    }
}
