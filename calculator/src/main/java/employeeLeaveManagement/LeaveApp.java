package employeeLeaveManagement;

import java.util.Scanner;

public class LeaveApp {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total leaves allocated per year: ");
        int totalAllocated = sc.nextInt();

        System.out.print("Enter leaves already taken: ");
        int leavesTaken = sc.nextInt();

        LeaveService leaveService = new LeaveService(totalAllocated, leavesTaken);

        System.out.println("Available Leaves: " + leaveService.getAvailableLeaves());

        System.out.print("Enter leave request days: ");
        int requestDays = sc.nextInt();

        try {
            boolean result = leaveService.applyLeave(requestDays);

            if (result) {
                System.out.println("Leave Approved ✅");
            } else {
                System.out.println("Leave Rejected  (Insufficient balance)");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

}
