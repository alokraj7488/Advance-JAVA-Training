package employeeLeaveManagement;

public class LeaveService {
	
	 private int totalLeavesAllocated;
	    private int leavesTaken;

	    public LeaveService(int totalLeavesAllocated, int leavesTaken) {
	        this.totalLeavesAllocated = totalLeavesAllocated;
	        this.leavesTaken = leavesTaken;
	    }

	    public int getAvailableLeaves() {
	        return totalLeavesAllocated - leavesTaken;
	    }

	    public boolean applyLeave(int leaveRequestDays) {

	   
	        if (leaveRequestDays <= 0) {
	            throw new IllegalArgumentException("Leave request days must be greater than 0");
	        }

	        int availableLeaves = getAvailableLeaves();

	      
	        if (leaveRequestDays <= availableLeaves) {
	            leavesTaken += leaveRequestDays; 
	            return true;
	        } else {
	            return false; 
	        }
	    }

	
	    public int getRemainingLeaves(int approvedLeaveDays) {
	        return totalLeavesAllocated - leavesTaken - approvedLeaveDays;
	    }

}
