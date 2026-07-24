import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Integrates all components: role selection, menu loops, operations,
// exception handling, and log viewing.
public class InventoryMain {
    private static final int LOW_STOCK_THRESHOLD = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        boolean systemRunning = true;

        // Welcome banner
        System.out.println("========================================================");
        System.out.println("        SMART INVENTORY MANAGEMENT SYSTEM");
        System.out.println("========================================================");

        while (systemRunning) {
            // Role Selection Menu
            System.out.println("Please Select Your Role");
            System.out.println("1. Store Manager (Admin)");
            System.out.println("2. Staff");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int roleChoice = readInt(scanner);
            scanner.nextLine(); // consume newline

            switch (roleChoice) {
                case 1:
                    // Store Manager login and full menu
                    StoreManager managerUser = new StoreManager("admin001", "Admin_Su", "admin123");
                    managerUser.displayUserDetails();  // prints the welcome message
                    System.out.println();

                    boolean managerLoggedIn = true;
                    while (managerLoggedIn) {
                        displayMainMenu();
                        int menuChoice = readInt(scanner);
                        scanner.nextLine();

                        switch (menuChoice) {
                            case 1:
                                addGroceryItem(scanner, manager);
                                break;
                            case 2:
                                addElectronicsItem(scanner, manager);
                                break;
                            case 3:
                                manager.showAllItems();
                                break;
                            case 4:
                                processSale(scanner, manager);
                                break;
                            case 5:
                                manager.checkLowStock(LOW_STOCK_THRESHOLD);
                                break;
                            case 6:
                                viewTransactionLogs();
                                break;
                            case 7:
                                managerLoggedIn = false;
                                System.out.println("Logging out...\n");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case 2:
                    // Staff login and limited menu
                    Staff staffUser = new Staff("staff001", "Staff_User", "staff123");
                    staffUser.displayUserDetails();  // prints the staff welcome
                    System.out.println();

                    boolean staffLoggedIn = true;
                    while (staffLoggedIn) {
                        displayStaffMenu();
                        int staffChoice = readInt(scanner);
                        scanner.nextLine();

                        switch (staffChoice) {
                            case 1:
                                manager.showAllItems();
                                break;
                            case 2:
                                manager.checkLowStock(LOW_STOCK_THRESHOLD);
                                break;
                            case 3:
                                staffLoggedIn = false;
                                System.out.println("Logging out...\n");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case 3:
                    systemRunning = false;
                    System.out.println("Thank you for using the Smart Inventory Management System.");
                    System.out.println("Session ended successfully.");
                    break;

                default:
                    System.out.println("Invalid role selection. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n================ MAIN MENU ================");
        System.out.println("1. Add Grocery Item");
        System.out.println("2. Add Electronics Item");
        System.out.println("3. Display Inventory");
        System.out.println("4. Process Sale");
        System.out.println("5. Check Low Stock");
        System.out.println("6. View Transaction Logs");
        System.out.println("7. Logout");
        System.out.print("Choose an option: ");
    }

    private static void displayStaffMenu() {
        System.out.println("\n================ STAFF MENU ================");
        System.out.println("1. Display Inventory");
        System.out.println("2. Check Low Stock");
        System.out.println("3. Logout");
        System.out.print("Choose an option: ");
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
        }
    }

    private static void addGroceryItem(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID : ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name : ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Quantity : ");
        int qty = readInt(scanner);
        scanner.nextLine();
        System.out.print("Enter Price : ");
        double price = readDouble(scanner);
        scanner.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD) : ");
        String expiry = scanner.nextLine().trim();

        GroceryItem item = new GroceryItem(id, name, qty, price, expiry);
        manager.addItem(item);
        System.out.println("=====================================");
        System.out.println("Item Added Successfully!");
        System.out.println(name + " has been added.");
        System.out.println("=====================================\n");
    }

    private static void addElectronicsItem(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID : ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name : ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Quantity : ");
        int qty = readInt(scanner);
        scanner.nextLine();
        System.out.print("Enter Price : ");
        double price = readDouble(scanner);
        scanner.nextLine();
        System.out.print("Enter Warranty (months) : ");
        int warranty = readInt(scanner);
        scanner.nextLine();

        ElectronicsItem item = new ElectronicsItem(id, name, qty, price, warranty);
        manager.addItem(item);
        System.out.println("=====================================");
        System.out.println("Item Added Successfully!");
        System.out.println(name + " has been added.");
        System.out.println("=====================================\n");
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
        }
    }

    private static void processSale(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID : ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Quantity : ");
        int qty = readInt(scanner);
        scanner.nextLine();

        try {
            manager.sellItem(id, qty);
            System.out.println("Sale Successful!");
        } catch (InventoryException e) {
            System.out.println("Business Logic Error");
            System.out.println(e.getMessage());
        }
    }

    private static void viewTransactionLogs() {
        String logFile = "inventory_logs.txt";
        System.out.println("\n================ TRANSACTION LOGS ================");
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No transaction logs found yet.");
        }
        System.out.println("===================================================\n");
    }
}