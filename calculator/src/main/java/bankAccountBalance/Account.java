package bankAccountBalance;

public class Account {
	private String accountNumber;
    private String accountHolderName;
    private double currentBalance;

    public Account(String accountNumber, String accountHolderName, double currentBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.currentBalance = currentBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }


}
