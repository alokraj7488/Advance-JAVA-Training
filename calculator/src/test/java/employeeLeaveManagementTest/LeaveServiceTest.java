package employeeLeaveManagementTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import employeeLeaveManagement.LeaveService;
import employeeLeaveManagement.LeaveApp;


public class LeaveServiceTest {

    private LeaveService leaveService;

    @BeforeEach
    void setUp() {
        
        leaveService = new LeaveService(20, 10);
    }

   
    @Test
    void testAvailableLeaveBalance() {
        int availableLeaves = leaveService.getAvailableLeaves();
        assertEquals(10, availableLeaves);   
    }

    
    @Test
    void testApproveLeaveRequest() {
        boolean result = leaveService.applyLeave(3);
        assertTrue(result);   
    }

    
    @Test
    void testRejectLeaveRequest() {
        boolean result = leaveService.applyLeave(15); 
        assertFalse(result);  
    }

    
    @Test
    void testRemainingLeaveBalance() {
        
        leaveService.applyLeave(5); 
        int remainingLeaves = leaveService.getRemainingLeaves(5);
        assertEquals(5, remainingLeaves);  
    }

    
    @Test
    void testInvalidLeaveRequest() {
        assertThrows(IllegalArgumentException.class,
                () -> leaveService.applyLeave(-2));   
    }
}

