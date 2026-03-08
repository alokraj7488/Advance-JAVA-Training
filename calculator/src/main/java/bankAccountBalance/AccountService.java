package bankAccountBalance;

public class AccountService {
	private static final double MIN_BALANCE = 1000.0;

	public double deposit(Account account, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be greater than 0");
		}
		double updatedBalance = account.getCurrentBalance() + amount;
		account.setCurrentBalance(updatedBalance);
		return updatedBalance;
	}

	public boolean withdraw(Account account, double amount) {
		if (amount <= account.getCurrentBalance()) {
			double updatedBalance = account.getCurrentBalance() - amount;
			account.setCurrentBalance(updatedBalance);
			return true;
		}
		return false;
	}

	public boolean checkMinimumBalance(Account account) {
		return account.getCurrentBalance() >= MIN_BALANCE;
	}

}
