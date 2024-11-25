package Handlejson;
import java.util.List;

public class jsondatastructure {
	public String url;
    public List<UserData> data;

    // Nested class for user data
    public static class UserData {
        public String username;
        public String password;

        // Getters and setters (optional)
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
    }
}