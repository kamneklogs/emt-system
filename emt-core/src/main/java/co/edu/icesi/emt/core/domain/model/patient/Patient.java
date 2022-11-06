package co.edu.icesi.emt.core.domain.model.patient;

import java.time.Instant;

import co.edu.icesi.emt.core.domain.model.patient.diseasehistorial.DiseaseHistorial;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.model.patient.nationality.NationalityState;

public class Patient {

    private final String id;
    private final Instant creationDate;
    private PersonalInformation personalInformation;
    private DiseaseHistorial diseaseHistorial;
    private NationalityState NationalityState;

    public Patient(String id, Instant creationDate, PersonalInformation personalInformation) {
        this.id = id;
        this.creationDate = creationDate;
        this.personalInformation = personalInformation;
    }

    public Patient(String id, Instant creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    public Patient(String id, Instant creationDate, PersonalInformation personalInformation,
            DiseaseHistorial diseaseHistorial) {
        this.id = id;
        this.creationDate = creationDate;
        this.personalInformation = personalInformation;
        this.diseaseHistorial = diseaseHistorial;
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

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public DiseaseHistorial getDiseaseHistorial() {
        return diseaseHistorial;
    }

    public void setDiseaseHistorial(DiseaseHistorial diseaseHistorial) {
        this.diseaseHistorial = diseaseHistorial;
    }
}
