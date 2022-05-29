import java.util.HashMap;
import java.util.Map;

import account.Account;
import account.AccountFactory;
import account.AccountType;
import employee.Employee;
import employee.EmployeeFactory;
import employee.EmployeeType;
import exception.AccountCollisionException;
import exception.BankException;
import exception.PermissionDeniedException;
import util.Util;

public class Bank {
    
    // employee name -> employee
    private Map<String, Employee> employeeMap;
    // account name -> account
    private Map<String, Account> accountMap;
    // loan pending for approval are stored in this map
    private Map<Account, Double> pendingLoanMap;

    // factory for creating employee object
    private EmployeeFactory employeeFactory;
    // factory for creating account object
    private AccountFactory accountFactory;

    /// clock variable to increament year count operation
    private int yearCount;

    /// initital fund
    private double initialFund;

    public Bank() {
        this.yearCount = 0;
        initialFund = 1000000;

        employeeFactory = new EmployeeFactory();
        accountFactory = new AccountFactory();

        accountMap = new HashMap<>();
        pendingLoanMap = new HashMap<>();
        employeeMap = new HashMap<>();

        // initial employee
        employeeMap.put("MD", employeeFactory.createEmployee(EmployeeType.ManagingDirector, "MD"));
        employeeMap.put("O1", employeeFactory.createEmployee(EmployeeType.Officer, "O1"));
        employeeMap.put("O2", employeeFactory.createEmployee(EmployeeType.Officer, "O2"));
        for (int i = 1; i <= 5; i++) {
            employeeMap.put("C" + i, employeeFactory.createEmployee(EmployeeType.Cashier, "C" + i));
        }

        System.out.println("Bank created; MD, O1, O2, C1, C2, C3, C4, C5 created");
    }

    /// acount operations ==============================================

    /**
     * After entering the system, users can request to open a new account with
     * their name, account type, and initial deposit
     * (or initial loan amount if the account is a loan account).
     */
    public void createAccount(String name, String accountType, double initialAmount)
            throws BankException {
        if (accountMap.containsKey(name)) {
            throw new AccountCollisionException();
        }
        Account account = accountFactory.createAccount(name, accountType, initialAmount);
        if (account != null) {
            accountMap.put(name, account);

            StringBuilder message = new StringBuilder()
                    .append(account.getAccountType())
                    .append(" acount for ")
                    .append(account.getName())
                    .append(" Created; initial deposit: ")
                    .append(Util.toMoneyString(account.getBalance()));
            initialFund += initialAmount;
            System.out.println(message.toString());
        } else {
            new BankException("Failed to create account");
        }
    }

    // withdraw
    public void withdraw(String name, double amount) throws BankException {
        Account account = accountMap.get(name);
        if (account != null) {
            account.withdraw(amount);
            initialFund -= amount;
            System.out.println(Util.toMoneyString(amount) + "$ withdrawn; current balance "
                    + Util.toMoneyString(account.getBalance()));
        } else {
            throw new BankException("Account not found");
        }
    }

    // request loan for loan account
    public void requestLoan(String name) throws BankException {
        Account account = accountMap.get(name);
        if (account != null) {
            // account.requestLoan(account.getLoan()*0.05);
            pendingLoanMap.put(account, account.getLoan() * 0.05);
            System.out.println("Loan request successful; sent for approval");
        } else {
            throw new BankException("Account not found");
        }
    }

    public void requestLoan(String name, double amount) throws BankException {
        Account account = accountMap.get(name);
        if (account != null) {
            // account.requestLoan(amount);
            pendingLoanMap.put(account, amount);
            System.out.println("Loan request successful; sent for approval");
        } else {
            throw new BankException("Account not found");
        }
    }

    public void queryDeposit(String name) throws BankException {
        Account account = accountMap.get(name);
        if (account != null) {
            String balance = "Current balance " + Util.toMoneyString(account.getBalance()) ;
            String loan = "loan " + Util.toMoneyString(account.getLoan());
            if (account.getAccountType() != AccountType.LOAN) {
                if (account.getLoan() == 0) {
                    System.out.println(balance);
                } else
                    System.out.println(balance + "," + loan);
            } else {
                System.out.println(loan);
            }
        } else {
            throw new BankException("Account not found");
        }
    }

    /// employee operations ===============================================

    public void lookup(String name, String accountName) throws BankException {
        if (employeeMap.containsKey(name)) {
            Employee employee = employeeMap.get(name);
            if (accountMap.containsKey(accountName)) {
                employee.lookup(accountMap.get(accountName));
            } else {
                throw new BankException("Bank Account not found");
            }
        } else {
            throw new BankException("Employee not found");
        }
    }

    public void approvePendingLoan(String name) throws BankException {
        if (employeeMap.containsKey(name)) {
            Employee employee = employeeMap.get(name);
            if (!pendingLoanMap.isEmpty()) {
                for (Account account : pendingLoanMap.keySet()) {
                    employee.approve(account, pendingLoanMap.get(account));
                    System.out.println("Loan for " + account.getName() + " approved");
                }
            }
        } else {
            throw new BankException("Account not found");
        }
    }

    public void changeInterestRate(String userName, String accountType, double interestRate) throws BankException {
        if (employeeMap.containsKey(userName)) {
            Employee employee = employeeMap.get(userName);
            for (Account account : pendingLoanMap.keySet()) {
                employee.changeInterestRate(account, interestRate / 100.0);
                System.out.println("Changed interest rate to " + interestRate);
            }
        } else {
            throw new BankException("Invalid employee name");
        }
    }

    public void seeInternalFund(String name) throws BankException {
        if (employeeMap.containsKey(name)) {
            Employee employee = employeeMap.get(name);
            if (employee.getEmployeeType() == EmployeeType.ManagingDirector) {
                System.out.println("Internal fund: " + Util.toMoneyString(initialFund));
            } else {
                throw new PermissionDeniedException();
            }
        } else {
            if (accountMap.containsKey(name)) {
                throw new PermissionDeniedException();
            } else {
                throw new BankException("Account not found");
            }
        }
    }

    // utility methods ===============================================

    public void increamentYear() {
        System.out.println("1 year passed");
        yearCount++;
        for (Account account : accountMap.values()) {
            account.applyYearlyInterest();
        }
    }

    /**
     * check is the account is a loan account
     * 
     * @param name is name of the account owner
     * @return true if the account is a loan account
     * @throws BankException is account not found
     */
    public boolean isLoanAccount(String name) throws BankException {
        if (accountMap.containsKey(name)) {
            return accountMap.get(name).getAccountType() == AccountType.LOAN;
        } else {
            throw new BankException("Account not found");
        }
    }

    /**
     * check if the name is a valid employee name
     * 
     * @param name the name to be checked
     * @return true if the name is a valid employee name
     */
    public boolean isEmployee(String name) {
        return employeeMap.containsKey(name);
    }

    /**
     * check if the name is a valid account owner name
     * 
     * @param name the name to be checked
     * @return  true if the name is a valid account owner name
     */
    public boolean isAccountUser(String name) {
        return accountMap.containsKey(name);
    }

    public void open(String name) throws BankException {
        // check if user account
        if (accountMap.containsKey(name)) {
            System.out.println("Welcome back, " + name);
        } else if (employeeMap.containsKey(name)) {
            Employee employee = employeeMap.get(name);

            if (employee.getEmployeeType() == EmployeeType.ManagingDirector
                    || employee.getEmployeeType() == EmployeeType.Officer) {
                if (!pendingLoanMap.isEmpty()) {
                    System.out.println(name + " active, there are loan approvals pending");
                } else {
                    System.out.println(name + " active, no loan approvals pending");
                }
            }
        } else {
            throw new BankException("Invalid user");
        }
    }

    /**
     * Get the account and update the balance
     * 
     * @param name is the name of the account owner
     * @param amount is the amount to be deposited
     * @throws BankException if the account is not found or the amount is invalid
     */
    public void deposit(String name, double amount) throws BankException {
        Account account = accountMap.get(name); //find the account
        if (account != null) {
            account.deposit(amount);
            System.out.println(Util.toMoneyString(amount) + " deposited; current balance "
                    + Util.toMoneyString(account.getBalance()));
        } else {
            throw new BankException("Account not found");
        }
    }

    /**
     * close the connection of current user
     * 
     * @param name is the name of the account owner
     * @throws BankException if the account is not found or user is not an employee
     */
    public void close(String name) throws BankException {
        if (isEmployee(name)) {
            System.out.println("Operations for " + name + " closed");
        } else if (isAccountUser(name)) {
            System.out.println("Transaction Closed for " + name);
        } else {
            throw new BankException("Invalid user");
        }
    }
}