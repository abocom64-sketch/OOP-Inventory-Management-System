
public interface InventoryOperations {

    // Add a new item to the inventory
    void addItem(Item newItem);

    // Sell (remove) some stock of an item. Throws InventoryException if
    // the item doesn't exist or there isn't enough stock left.
    void sellItem(String id, int amount) throws InventoryException;

    // Print out all items currently in the inventory
    void showAllItems();

    // Print out items whose stock has fallen below limit
    void checkLowStock(int limit);
}
