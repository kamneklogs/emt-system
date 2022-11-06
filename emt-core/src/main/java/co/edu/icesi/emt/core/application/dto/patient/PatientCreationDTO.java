package co.edu.icesi.emt.core.application.dto.patient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationModificationDTO;

public class PatientCreationDTO {

    private final String id;
    private final PersonalInformationModificationDTO personalInformation;

    @JsonCreator
    public PatientCreationDTO(@JsonProperty("id") String id,
            @JsonProperty("personalInformation") PersonalInformationModificationDTO personalInformation) {
        this.id = id;
        this.personalInformation = personalInformation;
    }

    public String getId() {
        return id;
    }

    public PersonalInformationModificationDTO getPersonalInformation() {
        return personalInformation;
    }
}
