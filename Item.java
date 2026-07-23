

public abstract class Item {

    private String id;
    private String itemName;
    private double price;
    private int stock;

    public Item(String id, String itemName, double price, int stock) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Each item should give a descriptions
    public abstract void showDetails();
}
