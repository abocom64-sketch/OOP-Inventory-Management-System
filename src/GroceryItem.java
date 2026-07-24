public class GroceryItem extends Item {

    private String expiryDate;

    public GroceryItem(String itemId, String itemName, int quantity, double price, String expiryDate) {
        super(itemId, itemName, quantity, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Price: RM " + getPrice());
        System.out.println("Expiry Date: " + expiryDate);
    }
}