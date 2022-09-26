package co.edu.icesi.emt.common.exception.model;

public class UserAccountDisabledException extends Exception implements EMTException {

    private static final String MSG = "This user is not enabled";
    private static final String DOMAIN_MSG = "Este usuario no está habilitado";

    public UserAccountDisabledException() {
        super(MSG);
    }

    @Override
    public String getDomainMessage() {
        return DOMAIN_MSG;
    }
}
