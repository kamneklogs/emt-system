package co.edu.icesi.emt.core.domain.model.personalinformation;

public enum CivilStatus {

    SINGLE("Soltero"),
    MARRIED("Casado"),
    DIVORCED("Divorciado"),
    WIDOWED("Viudo"),
    SEPARATED("Separado"),
    COHABITING("Conviviendo"),
    OTHER("Otro");

    private final String id;

    private CivilStatus(final String id) {
        this.id = id;
    }

    public static CivilStatus findById(String id) {
        for (CivilStatus civilStatus : CivilStatus.values()) {
            if (civilStatus.id.equals(id)) {
                return civilStatus;
            }
        }
        return null;
    }
}
