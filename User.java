public class User {

    private String userId;
    private String username;
    private String password;
    private String role;

    public User(String userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    //Setters

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //Login Method
    public boolean login(String inputUsername, String inputPassword) {
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            System.out.println("Login successful! WELCOME, " + username + ", "("+ role +")");
                return true;
        } else {
            System.out.println("Login Failed! Invalid username or password.");
            return false;
        }
    }

    //Display user details
    public void displayUserDetails() {
        System.out.println("====== User Details ======");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
        System.out.println("===========================");
    }
}