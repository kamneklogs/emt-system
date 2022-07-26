package co.edu.icesi.emt.auth.domain.model.user;

import java.time.Instant;

public class User {

    private String username;
    private String password;
    private Instant lastLogin;

    public User(String username, String password, Instant lastLogin) {
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
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

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User [lastLogin=" + lastLogin + ", password=" + password + ", username=" + username + "]";
    }
}