import java.util.Scanner;

public class OnlineExamination {
    private static String username = "user123";
    private static String password = "pass123";
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        login();
    }
    
    public static void login() {
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();
        
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
            displayMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            login();
        }
    }
    
    public static void displayMenu() {
        System.out.println("\nOnline Examination System Menu:");
        System.out.println("1. Update Profile");
        System.out.println("2. Update Password");
        System.out.println("3. Start Exam");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                updateProfile();
                break;
            case 2:
                updatePassword();
                break;
            case 3:
                startExam();
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
        }
    }
    
    public static void updateProfile() {
        System.out.println("Updating profile...");
        //  logic to update user profile
        System.out.println("Profile updated successfully!");
        displayMenu();
    }
    
    public static void updatePassword() {
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();
        if (!currentPassword.equals(password)) {
            System.out.println("Invalid password. Please try again.");
            updatePassword();
            return;
        }
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        password = newPassword; 
        System.out.println("Password updated successfully!");
        displayMenu();
    }
    
    public static void startExam() {
        System.out.println("Starting exam...");
        // logic for starting the exam, including timer and auto submit
        System.out.println("Exam completed!");
        displayMenu();
    }
    
    public static void logout() {
        System.out.println("Logging out...");
        // Implement any logout logic here
        System.out.println("Logged out successfully!");

        scanner.close();
        System.exit(0);
    }
}
