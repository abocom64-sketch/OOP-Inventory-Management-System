public class Staff extends User {//Represents a staff user in the system.

    public Staff(String userId, String username, String password) {
        super(userId, username, password, "Staff");
    }

    //Extends User and provides a specific welcome message.
    @Override
    public void displayUserDetails() {
        System.out.println("====================================");
        System.out.println("Welcome, Staff");
        System.out.println();
        System.out.println("Username     : " + getUsername());
        System.out.println("Access Level : Staff");
        System.out.println("====================================");
    }
}