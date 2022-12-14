package co.edu.icesi.emt.core.domain.model.clinicalhistory.patient;

import java.time.Instant;

public class ClinicalHistory {

    private int id;
    private String patientId;
    private String doctorId;
    private Instant createdAt;
    private int clinicalHistoryFormatId;
    private String payload;

    public ClinicalHistory(int id, String patientId, String doctorId, Instant createdAt, int clinicalHistoryFormatId,
            String payload) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public int getClinicalHistoryFormatId() {
        return clinicalHistoryFormatId;
    }

    public void setClinicalHistoryFormatId(int clinicalHistoryFormatId) {
        this.clinicalHistoryFormatId = clinicalHistoryFormatId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
