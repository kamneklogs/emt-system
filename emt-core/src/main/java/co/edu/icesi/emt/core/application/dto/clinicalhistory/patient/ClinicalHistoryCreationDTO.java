package co.edu.icesi.emt.core.application.dto.clinicalhistory.patient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;

public class ClinicalHistoryCreationDTO {

    private final String patientId;
    private final String doctorId;
    private final int clinicalHistoryFormatId;
    private final String payload;

    @JsonCreator
    public ClinicalHistoryCreationDTO(@JsonProperty("patientId") String patientId,
            @JsonProperty("doctorId") String doctorId,
            @JsonProperty("clinicalHistoryFormatId") int clinicalHistoryFormatId,
            @JsonProperty("payload") String payload) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.clinicalHistoryFormatId = clinicalHistoryFormatId;
        this.payload = payload;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public int getClinicalHistoryFormatId() {
        return clinicalHistoryFormatId;
    }

    public String getPayload() {
        return payload;
    }

    public static ClinicalHistory fromDTO(ClinicalHistoryCreationDTO dto) {
        return new ClinicalHistory(0,
                dto.getPatientId(),
                dto.getDoctorId(),
                null,
                dto.clinicalHistoryFormatId,
                dto.getPayload());
    }
}
