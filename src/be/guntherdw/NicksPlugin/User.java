package be.guntherdw.NicksPlugin;

/**
 * @author GuntherDW
 */
public class User {

    private String username;
    private String displayName;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
