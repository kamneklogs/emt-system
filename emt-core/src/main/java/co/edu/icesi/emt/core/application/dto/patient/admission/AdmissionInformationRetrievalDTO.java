package co.edu.icesi.emt.core.application.dto.patient.admission;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;

public class AdmissionInformationRetrievalDTO {

    private final int id;
    private String patientId;
    private final String caretaker;
    private final String caretakerPhoneNumber;
    private final Instant admissionDate;
    private final String medicalConsultationReason;

    @JsonCreator
    public AdmissionInformationRetrievalDTO(@JsonProperty("id") int id,
            @JsonProperty("patientId") String patientId,
            @JsonProperty("caretaker") String caretaker,
            @JsonProperty("caretakerPhoneNumber") String caretakerPhoneNumber,
            @JsonProperty("admissionDate") Instant admissionDate,
            @JsonProperty("medicalConsultationReason") String medicalConsultationReason) {
        this.id = id;
        this.patientId = patientId;
        this.caretaker = caretaker;
        this.caretakerPhoneNumber = caretakerPhoneNumber;
        this.admissionDate = admissionDate;
        this.medicalConsultationReason = medicalConsultationReason;
    }

    public int getId() {
        return id;
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

    public static AdmissionInformationRetrievalDTO from(AdmissionInformation admissionInformation) {
        return new AdmissionInformationRetrievalDTO(admissionInformation.getId(),
                admissionInformation.getPatientId(),
                admissionInformation.getCaretaker(),
                admissionInformation.getCaretakerPhoneNumber(),
                admissionInformation.getAdmissionDate(),
                admissionInformation.getMedicalConsultationReason());
    }

    public static List<AdmissionInformationRetrievalDTO> from(List<AdmissionInformation> admissionInformations) {
        return admissionInformations.stream().map(AdmissionInformationRetrievalDTO::from).toList();
    }
}
