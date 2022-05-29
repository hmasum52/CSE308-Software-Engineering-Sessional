package employee;
import account.Account;
import exception.PermissionDeniedException;

public class ManagingDirector extends Employee {
    public ManagingDirector(String name) {
        super(name, EmployeeType.ManagingDirector);
    }

    @Override
    public void changeInterestRate(Account account, double rate) throws PermissionDeniedException {
        account.getAccountType().setInterestRate(rate);
    }
}
