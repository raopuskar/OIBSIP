import java.util.Scanner;

class User {
    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private int pnr;
    private int trainNumber;
    private String classType;
    private String dateOfJourney;
    private String source;
    private String destination;

  
    public Reservation(int pnr, int trainNumber, String classType, String dateOfJourney, String source, String destination) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.source = source;
        this.destination = destination;
    }

    // Getter for PNR
    public int getPNR() {
        return pnr;
    }

    // Method to print reservation details
    public void printDetails() {
        System.out.println("PNR: " + pnr);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
    }
}

public class OnlineReservationSystem {
    private static final int MAX_RESERVATIONS = 100; 
    private static Reservation[] reservations = new Reservation[MAX_RESERVATIONS];
    private static int nextPNR = 1; 

    public static int makeReservation(int trainNumber, String classType, String dateOfJourney, String source, String destination) {
        if (nextPNR < MAX_RESERVATIONS) {
            int pnr = nextPNR++;
            Reservation reservation = new Reservation(pnr, trainNumber, classType, dateOfJourney, source, destination);
            reservations[pnr - 1] = reservation; 
            return pnr;
        } else {
            System.out.println("Maximum reservations reached. Cannot make reservation.");
            return -1; 
        }
    }

    // Method to cancel a reservation
    public static void cancelReservation(int pnr) {
        // Check if the given PNR is valid
        if (pnr >= 1 && pnr <= nextPNR && reservations[pnr - 1] != null) {
            // Display reservation details
            System.out.println("Reservation details:");
            reservations[pnr - 1].printDetails();
            // Ask user if they want to cancel reservation
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to cancel this reservation? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("yes")) {
                // Remove reservation by setting the corresponding array element to null
                reservations[pnr - 1] = null;
                System.out.println("Reservation with PNR " + pnr + " has been cancelled.");
            } else {
                System.out.println("Reservation cancellation cancelled.");
            }
        } else {
            System.out.println("Invalid PNR.");
        }
    }

    // Method to print details of all reservations
    public static void printAllReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            if (reservation != null) {
                reservation.printDetails();
                System.out.println();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User name and password
        User user = new User("username", "password");

        // Login Form
        System.out.println("Please login to access the Online Reservation System:");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(user.getUsername()) && inputPassword.equals(user.getPassword())) {
            System.out.println("Login successful!");
            // Proceed with reservation or cancellation
            int choice;
            do {
                System.out.println("What would you like to do?");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. View all reservations");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.println("Enter details for the reservation:");
                        System.out.print("Train Number: ");
                        int trainNumber = scanner.nextInt();
                        System.out.print("Class Type: ");
                        String classType = scanner.next();
                        System.out.print("Date of Journey (YYYY-MM-DD): ");
                        String dateOfJourney = scanner.next();
                        System.out.print("Source: ");
                        String source = scanner.next();
                        System.out.print("Destination: ");
                        String destination = scanner.next();
                        int pnr = makeReservation(trainNumber, classType, dateOfJourney, source, destination);
                        if (pnr != -1) {
                            System.out.println("Reservation successful! PNR number: " + pnr);
                        }
                        break;
                    case 2:
                        System.out.print("Enter PNR number to cancel: ");
                        int pnrNumber = scanner.nextInt();
                        cancelReservation(pnrNumber);
                        break;
                    case 3:
                        printAllReservations();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }
}
