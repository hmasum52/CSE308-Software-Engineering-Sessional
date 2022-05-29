package account;

public enum AccountType {
    FIXED_DEPOSITE("FixedDeposite"),
    LOAN("Loan"),
    STUDENT("Student"),
    SAVINGS("Savings");

    private String name;
    private double interestRate;

    private AccountType(String name) {
        this.name = name;
        init(name);
    }

    private void init(String name){
        switch (name) {
            case "FixedDeposite":
                interestRate = 0.15; // 15% interest for fixed deposite
                break;
            case "Student":
                interestRate = 0.05; // 5% interest for student
                break;
            case "Savings":
                interestRate = 0.1; // 10% interest for savings
                break;
            default:
                interestRate = 0.0;
                break;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
