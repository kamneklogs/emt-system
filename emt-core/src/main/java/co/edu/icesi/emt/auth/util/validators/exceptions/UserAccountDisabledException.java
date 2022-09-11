package co.edu.icesi.emt.auth.util.validators.exceptions;

public class UserAccountDisabledException extends Exception {

    private static final String USER_IS_NOT_ENABLED = "This user is not enabled";

    public UserAccountDisabledException() {
        super(USER_IS_NOT_ENABLED);
    }
}
