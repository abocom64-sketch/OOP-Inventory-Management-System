
public class GroceryItem extends Item {

    private String expiry;

    public GroceryItem(String id, String itemName, double price, int stock, String expiry) {
        super(id, itemName, price, stock);
        this.expiry = expiry;
    }

    public String getExpiry() {
        return expiry;
    }

    @Override
    public void showDetails() {
        System.out.println("Item ID: " + getId());
        System.out.println("Name: " + getItemName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Stock: " + getStock());
        System.out.println("Expiry Date: " + expiry);
    }
}
