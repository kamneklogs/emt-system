package co.edu.icesi.emt.core.domain.model.personalinformation;

public enum Gender {

    FEMALE("Femenino"),
    MALE("Masculino"),
    NON_BINARY("No binario");

    private final String id;

    private Gender(final String id) {
        this.id = id;
    }

    public static Gender findById(String id) {
        for (Gender gender : Gender.values()) {
            if (gender.id.equals(id)) {
                return gender;
            }
        }
        return null;
    }
}
