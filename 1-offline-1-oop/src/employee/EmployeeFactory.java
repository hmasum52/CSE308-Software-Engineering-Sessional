package employee;
/**
 * @author Hasan Masum
 * 
 * This class is the factory class for creating employee objects.
 */
public class EmployeeFactory {
    public Employee createEmployee(EmployeeType employeeType, String name) {
        switch (employeeType) {
            case Cashier:
                return new Cashier(name);
            case Officer:
                return new Officer(name);
            case ManagingDirector:
                return new ManagingDirector(name);
            default:
                return null;
        }
    }
}
