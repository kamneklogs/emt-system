package co.edu.icesi.emt.core.application.dto.patient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.application.dto.patient.admission.AdmissionInformationDTO;
import co.edu.icesi.emt.core.application.dto.patient.affiliation.AffiliationInformationDTO;
import co.edu.icesi.emt.core.application.dto.patient.nationality.NationalityStateModificationDTO;
import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationModificationDTO;
import co.edu.icesi.emt.core.domain.model.patient.Patient;

public class PatientCreationDTO {

    private final String id;
    private final PersonalInformationModificationDTO personalInformation;

    private final NationalityStateModificationDTO nationalityState;

    private final AdmissionInformationDTO admissionInformation;

    private final AffiliationInformationDTO affiliationInformation;

    @JsonCreator
    public PatientCreationDTO(@JsonProperty("id") String id,
            @JsonProperty("personalInformation") PersonalInformationModificationDTO personalInformation,
            @JsonProperty("nationalityState") NationalityStateModificationDTO nationalityState,
            @JsonProperty("admissionInformation") AdmissionInformationDTO admissionInformation,
            @JsonProperty("medicalConsultation.medicalConsultationReason") String medicalConsultationReason,
            @JsonProperty("affiliationInformation") AffiliationInformationDTO affiliationInformation) {
        this.id = id;
        this.personalInformation = personalInformation;
        this.nationalityState = nationalityState;
        this.admissionInformation = admissionInformation;
        admissionInformation.setPatientId(id);
        admissionInformation.setMedicalConsultationReason(medicalConsultationReason);
        this.affiliationInformation = affiliationInformation;
    }

    public String getId() {
        return id;
    }

    public PersonalInformationModificationDTO getPersonalInformation() {
        return personalInformation;
    }

    public NationalityStateModificationDTO getNationalityState() {
        return nationalityState;
    }

    public AdmissionInformationDTO getAdmissionInformation() {
        return admissionInformation;
    }

    public AffiliationInformationDTO getAffiliationInformation() {
        return affiliationInformation;
    }

    public static Patient fromDTO(PatientCreationDTO dto) {
        return new Patient(dto.getId(), PersonalInformationModificationDTO.fromDTO(dto.getPersonalInformation()),
                NationalityStateModificationDTO.fromDTO(dto.getNationalityState()),
                AffiliationInformationDTO.fromDTO(dto.getAffiliationInformation()));
    }
}
