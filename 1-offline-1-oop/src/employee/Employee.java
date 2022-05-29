package employee;

import account.Account;
import exception.BankException;
import exception.PermissionDeniedException;
import util.Util;

public abstract class Employee {
    protected String name;
    protected EmployeeType employeeType;

    public Employee(String name, EmployeeType employeeType) {
        this.name = name;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    /**
     * Any employee can see the deposit sum of any user account.
     * 
     * @param account the account to be lookup
     */
    public void lookup(Account account) {
        System.out.println(account.getName() + "'s current balance " + Util.toMoneyString(account.getBalance()));
    }

    /**
     * The Managing director and officer can approve loan requests of users
     * 
     * @param account the account to be approved
     * @thorws PermissionDeniedException if the employee is not an officer or
     *         managing director
     */
    public void approve(Account account, double amount)
            throws BankException {
        account.requestLoan(amount);
    }

    /**
     * The managing director has the discretion to change the interest
     * rates of different types of accounts
     * 
     * @param rate the new interest rate
     *
     * @throws PermissionDeniedException if the employee is not the managing
     *                                   director
     *
     */
    public abstract void changeInterestRate(Account account, double rate) throws PermissionDeniedException;

}
