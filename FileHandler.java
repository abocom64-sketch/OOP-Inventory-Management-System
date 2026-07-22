import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler {

    private static final String FILE_NAME = "inventory_logs.txt"; // stores file names where all logs will be stored

    public static void logTransaction(String action, String itemName, int quantity) { // action is type of log, itemName is the name of the item, quantity is the number of items involved in the transaction
          
        try {

            FileWriter fileWriter = new FileWriter(FILE_NAME, true); // true means it will add new logs without replacing the previous ones
            PrintWriter writer = new PrintWriter(fileWriter);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Added to make the date and time more readable

            String dateTime = LocalDateTime.now().format(formatter); // Get the current date and time in the specified format

            writer.println("================ INVENTORY LOG ================"); // Format for the txt file
            writer.println();
            writer.println("Date   : " + dateTime);
            writer.println("Action : " + action);
            writer.println("Item   : " + itemName);
            writer.println("Quantity    : " + quantity);
            writer.println();
            writer.println("===============================================");
            writer.println();

            writer.close();

        } catch (IOException e) {
          // Handle the exception if there is an error writing to the log file
            System.out.println("Error writing log file: " + e.getMessage());

        }
    }
}