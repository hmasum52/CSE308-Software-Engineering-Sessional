package employee;

import account.Account;
import exception.PermissionDeniedException;

public class Officer extends Employee {
    public Officer(String name) {
        super(name, EmployeeType.Officer);
    }

    @Override
    public void changeInterestRate(Account account,double rate) throws PermissionDeniedException {
        throw new PermissionDeniedException();
    }
}
