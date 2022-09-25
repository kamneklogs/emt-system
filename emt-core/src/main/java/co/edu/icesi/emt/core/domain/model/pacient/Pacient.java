package co.edu.icesi.emt.core.domain.model.pacient;

import java.time.Instant;

import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;

public class Pacient {

    private final String id;
    private final Instant creationDate;
    private final PersonalInformation personalInformation;

    public Pacient(String id, Instant creationDate, PersonalInformation personalInformation) {
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

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }
}
