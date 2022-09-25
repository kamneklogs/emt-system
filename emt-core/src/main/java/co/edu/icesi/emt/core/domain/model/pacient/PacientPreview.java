package co.edu.icesi.emt.core.domain.model.pacient;

import java.time.Instant;

import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformationPreview;

public class PacientPreview {

    private final String id;
    private final Instant creationDate;
    private final PersonalInformationPreview personalInformation;

    public PacientPreview(String id, Instant creationDate, PersonalInformationPreview personalInformation) {
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

    public PersonalInformationPreview getPersonalInformation() {
        return personalInformation;
    }
}
