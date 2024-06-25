package dbmodels;

/**
 * Implements the User model. Users store in 'users' table.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String created_at;

    protected User() {}

    private User(String username, String password, String email, String created_at) {
       this.username = username;
       this.password = password;
       this.created_at = created_at;
       this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


    @Override
    public String toString() {
        return "User: " + username + ", " + email + ", " + created_at;
    }
}
