package co.edu.icesi.emt.auth.util.exceptions;

public class RootAdminCanNotBeRemovedException extends Exception {

    private static final String ROOT_ADMIN_CAN_NOT_BE_REMOVED = "Root admin can not be removed";

    public RootAdminCanNotBeRemovedException() {
        super(ROOT_ADMIN_CAN_NOT_BE_REMOVED);
    }
}
