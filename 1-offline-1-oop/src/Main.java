import java.util.Scanner;

import exception.BankException;
public class Main {
    public static void main(String[] args) {    

        Bank bank = new Bank();
        String activeClient = "";

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");

            try {
                if(input[0].equals("Exit")){
                    break;
                }
                switch(input[0]){
                    case "Create":
                        bank.createAccount(input[1], input[2], Double.parseDouble(input[3]));
                        activeClient = input[1];
                        break;
                    case "Deposit":
                        bank.deposit(activeClient, Double.parseDouble(input[1]));
                        break;
                    case "Withdraw":
                        bank.withdraw(activeClient, Double.parseDouble(input[1]));
                        break;
                    case "Request":
                        boolean isLoan = bank.isLoanAccount(activeClient);
                        if(!isLoan){
                            bank.requestLoan(activeClient, Double.parseDouble(input[1]));
                        }else{
                            bank.requestLoan(activeClient);
                        }
                        break;
                    case "Query":
                        bank.queryDeposit(activeClient);
                        break;
                    case "Approve":
                        bank.approvePendingLoan(activeClient);
                        break;
                    case "Change":
                        bank.changeInterestRate(activeClient, input[1], Double.parseDouble(input[2]));
                        break;
                    case "Lookup":
                        bank.lookup(activeClient, input[1]);
                        break;
                    case "See":
                        bank.seeInternalFund(activeClient);
                        break;
                    case "INC":
                        bank.increamentYear();
                        break;
                    case "Open":
                        bank.open(input[1]);
                        activeClient = input[1];
                        break;
                    case "Close":
                        bank.close(activeClient);
                        break;
                    default:
                        System.out.println("Invalid command!");
                        break;
                }
            }
            catch(BankException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Unexpected error");
            }
        }
        scanner.close();
    }
}
