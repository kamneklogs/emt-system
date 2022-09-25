package co.edu.icesi.emt.core.application.dto.pacient;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.pacient.Pacient;

public class PacientRetrievalDTO {

    private final String id;
    private final Instant creationDate;
    private final PersonalInformationRetrievalDTO personalInformation;

    @JsonCreator
    public PacientRetrievalDTO(@JsonProperty("id") String id, @JsonProperty("creationDate") Instant creationDate,
            @JsonProperty("personalInformation") PersonalInformationRetrievalDTO personalInformation) {
        this.id = id;
        this.creationDate = creationDate;
        this.personalInformation = personalInformation;
    }

    public String getId() {
        return id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public PersonalInformationRetrievalDTO getPersonalInformation() {
        return personalInformation;
    }

    public static PacientRetrievalDTO from(Pacient pacient) {
        return new PacientRetrievalDTO(pacient.getId(), pacient.getCreationDate(),
                PersonalInformationRetrievalDTO.from(pacient.getPersonalInformation()));
    }
}
