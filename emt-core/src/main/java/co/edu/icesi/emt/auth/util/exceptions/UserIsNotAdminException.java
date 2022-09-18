package co.edu.icesi.emt.auth.util.exceptions;

public class UserIsNotAdminException extends Exception {

    private static final String USER_IS_NOT_ADMIN_MSG = "This user is not administrator";

    public UserIsNotAdminException() {
        super(USER_IS_NOT_ADMIN_MSG);
    }
}