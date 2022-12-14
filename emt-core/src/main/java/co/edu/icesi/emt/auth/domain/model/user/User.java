package co.edu.icesi.emt.auth.domain.model.user;

import java.time.Instant;

public class User {

    private String username;
    private String password;
    private String professionalCard;
    private Instant lastLogin;
    private boolean enabled;

    public User(String username, String password, String professionalCard, Instant lastLogin, boolean enabled) {
        this.username = username;
        this.password = password;
        this.professionalCard = professionalCard;
        this.lastLogin = lastLogin;
        this.enabled = enabled;
    }

    public User(String username, String password, Instant lastLogin, boolean enabled) {
        this.username = username;
        this.password = password;
        this.professionalCard = "";
        this.lastLogin = lastLogin;
        this.enabled = enabled;
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

    public String getProfessionalCard() {
        return professionalCard;
    }

    public void setProfessionalCard(String professionalCard) {
        this.professionalCard = professionalCard;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User [lastLogin=" + lastLogin + ", username=" + username + "]";
    }
}