package employee;

import account.Account;
import exception.PermissionDeniedException;

public class Cashier extends Employee {
    protected String name;

    public Cashier(String name) {
        super(name, EmployeeType.Cashier);
    }

    @Override
    public void approve(Account account, double amount) throws PermissionDeniedException {
        throw new PermissionDeniedException();
    }

    @Override
    public void changeInterestRate(Account account, double rate) throws PermissionDeniedException {
        throw new PermissionDeniedException();
    }
}
