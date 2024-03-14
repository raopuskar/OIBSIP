import java.util.Scanner;

public class atmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        
        while (!isLoggedIn) {
            System.out.print("Enter user ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter user PIN: ");
            String userPin = scanner.nextLine();
            
            
            if (userId.equals("123") && userPin.equals("456")) {
                isLoggedIn = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid user ID or PIN. Please try again.");
            }
        }
        
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
    
    public static void viewTransactionHistory() {
        System.out.println("Transaction history:");
        // logic
    }
    
    public static void withdraw() {
        // logic
        System.out.println("Withdraw function called.");
    }
    
    public static void deposit() {
        // logic
        System.out.println("Deposit function called.");
    }
    
    public static void transfer() {
        //logic
        System.out.println("Transfer function called.");
    }
}
