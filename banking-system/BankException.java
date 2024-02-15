
package bankingSystem;

public class BankException extends Exception {

    public static class InvalidAccountException extends BankException {
        public InvalidAccountException() {
            System.out.println("Account Number in not Valid.It should contain 12 digits");
        }
    }

    // NegativeAmountException nested class
    public static class NegativeAmountException extends BankException {
        public NegativeAmountException() {
            System.out.println("Amount cannot be negative");
        }
    }

    //InsufficientFundsException
    public static class InsufficientFundsException extends BankException {
        public InsufficientFundsException() {
            System.out.println("Insufficient Balance");
        }
    }

    //NonExistenceAccountException
    public static class NonExistenceAccountException extends BankException {
        public NonExistenceAccountException() {
            System.out.println("The Account does not exists");
        }
    }
}

