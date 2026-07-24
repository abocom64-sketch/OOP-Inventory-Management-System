import java.util.ArrayList;

public class InventoryManager implements InventoryOperations {

    // Holds every item currently in the store
    private ArrayList<Item> stockList;

    public InventoryManager() {
        this.stockList = new ArrayList<Item>();
    }

    @Override
    public void addItem(Item newItem) {
        stockList.add(newItem);
        System.out.println("Added: " + newItem.getItemName() + " (Stock: " + newItem.getQuantity() + ")");

        // Log this action to the log file (Person 4's FileHandler)
        FileHandler.logTransaction("ADD", newItem.getItemName(), newItem.getQuantity());
    }

    @Override
    public void sellItem(String id, int amount) throws InventoryException {
        // Look for the item with this id
        Item match = null;
        for (Item current : stockList) {
            if (current.getItemId().equals(id)) {
                match = current;
                break;
            }
        }

        // If we never found the item , we display an error
        if (match == null) {
            throw new InventoryException("Item with ID " + id + " was not found in inventory.");
        }

        // If there isn't enough stock, we display an error
        if (match.getQuantity() < amount) {
            throw new InventoryException("Not enough stock for " + match.getItemName()
                    + ". Available: " + match.getQuantity() + ", Requested: " + amount);
        }

        // Otherwise, reduce the stock and log the sale
        match.setQuantity(match.getQuantity() - amount);
        System.out.println("Sold " + amount + " of " + match.getItemName()
                + ". Remaining stock: " + match.getQuantity());

        FileHandler.logTransaction("SELL", match.getItemName(), amount);
    }

    @Override
    public void showAllItems() {
        System.out.println("====== Current Inventory ======");

        if (stockList.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            for (Item current : stockList) {
                current.displayDetails();
                System.out.println("--------------------------------");
            }
        }

        System.out.println("================================");
    }

    @Override
    public void checkLowStock(int limit) {
        System.out.println("====== Low Stock Items (below " + limit + ") ======");

        boolean lowStockFound = false;
        for (Item current : stockList) {
            if (current.getQuantity() < limit) {
                System.out.println(current.getItemName() + " - Stock: " + current.getQuantity());
                lowStockFound = true;
            }
        }

        if (!lowStockFound) {
            System.out.println("No items are low on stock.");
        }

        System.out.println("=======================================");
    }
}
