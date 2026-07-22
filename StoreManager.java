public class StoreManager extends User {

    public StoreManager(String userId, String username, String password) {
        super(userId, username, password, "Store Manager");
    }

    @Override
    public void displayUserDetails() {
        super.displayUserDetails();
        System.out.println("Access Level: Store Manager");
    }
}