public class StoreManager extends User {

    public StoreManager(String userId, String username, String password) {
        super(userId, username, password, "Store Manager");
    }

    @Override
    public void displayUserDetails() {

        System.out.println("====================================");
        System.out.println("Welcome, Store Manager");
        System.out.println();
        System.out.println("Username     : " + getUsername());
        System.out.println("Access Level : Administrator");
        System.out.println("====================================");
    }
}