package co.edu.icesi.emt.core.domain.model.patient.admission;

import java.time.Instant;

public class AdmissionInformation {

    private int id;
    private final String patientId;
    private final String caretaker;
    private final String caretakerPhoneNumber;
    private final Instant admissionDate;
    private final String medicalConsultationReason;

    public AdmissionInformation(int id, String patientId, String caretaker, String caretakerPhoneNumber,
            Instant admissionDate,
            String medicalConsultationReason) {
        this.id = id;
        this.patientId = patientId;
        this.caretaker = caretaker;
        this.caretakerPhoneNumber = caretakerPhoneNumber;
        this.admissionDate = admissionDate;
        this.medicalConsultationReason = medicalConsultationReason;
    }

    public AdmissionInformation(String patientId, String caretaker, String caretakerPhoneNumber,
            Instant admissionDate,
            String medicalConsultationReason) {
        this.patientId = patientId;
        this.caretaker = caretaker;
        this.caretakerPhoneNumber = caretakerPhoneNumber;
        this.admissionDate = admissionDate;
        this.medicalConsultationReason = medicalConsultationReason;
    }

    public int getId() {
        return id;
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
}
