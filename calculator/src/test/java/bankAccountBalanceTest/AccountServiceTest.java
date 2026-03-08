package bankAccountBalanceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankAccountBalance.Account;
import bankAccountBalance.AccountService;

public class AccountServiceTest {
	private Account account;
    private AccountService service;

    @BeforeEach
    void setUp() {
        account = new Account("ACC101", "Supriya Kumari", 5000.0);
        service = new AccountService();
    }

  
    @Test
    void testDepositAmount() {
        double updatedBalance = service.deposit(account, 1000);
        assertEquals(6000, updatedBalance);   
    }


    @Test
    void testWithdrawAmount() {
        boolean result = service.withdraw(account, 2000);
        double updatedBalance = account.getCurrentBalance();

        assertTrue(result);
        assertEquals(3000, updatedBalance);   
    }

    
    @Test
    void testWithdrawMoreThanBalance() {
        boolean result = service.withdraw(account, 6000);
        assertFalse(result);   
    }

    
    @Test
    void testMinimumBalanceValidation() {
        boolean result = service.checkMinimumBalance(account);
        assertTrue(result);   
    }
}
