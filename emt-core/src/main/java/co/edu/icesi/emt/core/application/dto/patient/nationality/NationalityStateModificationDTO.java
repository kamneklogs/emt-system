package co.edu.icesi.emt.core.application.dto.patient.nationality;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.patient.nationality.MigratoryState;
import co.edu.icesi.emt.core.domain.model.patient.nationality.NationalityState;

public class NationalityStateModificationDTO {

    private final String nationality;
    private final int nationalityStateCode;
    private final String nationalityStateName;

    @JsonCreator
    public NationalityStateModificationDTO(@JsonProperty("nationality") String nationality,
            @JsonProperty("nationalityStateCode") int nationalityStateCode,
            @JsonProperty("nationalityStateName") String nationalityStateName) {
        this.nationality = nationality;
        this.nationalityStateCode = nationalityStateCode;
        this.nationalityStateName = nationalityStateName;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNationalityStateCode() {
        return nationalityStateCode;
    }

    public String getNationalityStateName() {
        return nationalityStateName;
    }

    public static NationalityState fromDTO(NationalityStateModificationDTO nationalityState) {
        return new NationalityState(nationalityState.getNationality(),
                MigratoryState.byId(nationalityState.getNationalityStateCode()));
    }
}
