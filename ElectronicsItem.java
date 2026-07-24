public class ElectronicsItem extends Item {
// Represents an electronic product in the inventory.
// Extends the abstract Item class and adds warranty information.
    private int warrantyMonths;

    /**
     * Constructs an ElectronicsItem with all required attributes.
     * @param itemId        unique identifier
     * @param itemName      product name
     * @param quantity      stock quantity
     * @param price         price per unit (in RM)
     * @param warrantyMonths warranty duration in months
     */

    public ElectronicsItem(String itemId, String itemName, int quantity, double price, int warrantyMonths) {
        super(itemId, itemName, quantity, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    
    // Displays the electronics item details in the required format.
    // Overrides the abstract method from Item.

    @Override
    public void displayDetails() {
        System.out.println("[Electronics]");
        System.out.println("ID     : " + getItemId());
        System.out.println("Name     : " + getItemName());
        System.out.println("Quantity : " + getQuantity());
        System.out.println("Price    : RM" + String.format("%.2f", getPrice()));
        System.out.println("Warranty : " + warrantyMonths + " Months");
    }
}