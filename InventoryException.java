public class InventoryException extends Exception { 

    // It acts as a constructor which receives a message as a parameter and passes it to the parent Exception to set the exception message. This allows you to create an InventoryException with a custom error message when throwing the exception in your code.
    public InventoryException(String message) {
        super(message);
    }
}