package co.edu.icesi.emt.core.application.dto.clinicalhistory.patient;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;

public class ClinicalHistoryRetrievalDTO {

    private final int id;
    private final String patientId;
    private final String doctorId;
    private final Instant createdAt;
    private final int clinicalHistoryFormatId;
    private final String payload;

    @JsonCreator
    public ClinicalHistoryRetrievalDTO(@JsonProperty("id") int id,
            @JsonProperty("patientId") String patientId,
            @JsonProperty("doctorId") String doctorId,
            @JsonProperty("createdAt") Instant createdAt,
            @JsonProperty("clinicalHistoryFormatId") int clinicalHistoryFormatId,
            @JsonProperty("payload") String payload) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdAt = createdAt;
        this.clinicalHistoryFormatId = clinicalHistoryFormatId;
        this.payload = payload;
    }

    public int getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public int getClinicalHistoryFormatId() {
        return clinicalHistoryFormatId;
    }

    public String getPayload() {
        return payload;
    }

    public static ClinicalHistoryRetrievalDTO from(ClinicalHistory clinicalHistory) {
        return new ClinicalHistoryRetrievalDTO(
                clinicalHistory.getId(),
                clinicalHistory.getPatientId(),
                clinicalHistory.getDoctorId(),
                clinicalHistory.getCreatedAt(),
                clinicalHistory.getClinicalHistoryFormatId(),
                clinicalHistory.getPayload());
    }

    public static List<ClinicalHistoryRetrievalDTO> from(List<ClinicalHistory> clinicalHistories) {
        return clinicalHistories.stream()
                .map(ClinicalHistoryRetrievalDTO::from)
                .collect(Collectors.toList());
    }
}
