package co.edu.icesi.emt.core.application.dto.patient.admission;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;

public class AdmissionInformationDTO {

    private String patientId;
    private final String caretaker;
    private final String caretakerPhoneNumber;
    private final Instant admissionDate;
    private String medicalConsultationReason;

    @JsonCreator
    public AdmissionInformationDTO(@JsonProperty("patientId") String patientId,
            @JsonProperty("caretaker") String caretaker,
            @JsonProperty("caretakerPhoneNumber") String caretakerPhoneNumber,
            @JsonProperty("admissionDate") Instant admissionDate,
            @JsonProperty("medicalConsultationReason") String medicalConsultationReason) {
        this.patientId = patientId;
        this.caretaker = caretaker;
        this.caretakerPhoneNumber = caretakerPhoneNumber;
        this.admissionDate = admissionDate;
        this.medicalConsultationReason = medicalConsultationReason;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public String getCaretakerPhoneNumber() {
        return caretakerPhoneNumber;
    }

    public Instant getAdmissionDate() {
        return admissionDate;
    }

    public String getMedicalConsultationReason() {
        return medicalConsultationReason;
    }

    public void setMedicalConsultationReason(String medicalConsultationReason) {
        this.medicalConsultationReason = medicalConsultationReason;
    }

    public static AdmissionInformation fromDTO(AdmissionInformationDTO admissionInformationDTO) {
        return new AdmissionInformation(admissionInformationDTO.getPatientId(),
                admissionInformationDTO.getCaretaker(),
                admissionInformationDTO.getCaretakerPhoneNumber(), admissionInformationDTO.getAdmissionDate(),
                admissionInformationDTO.getMedicalConsultationReason());
    }
}
