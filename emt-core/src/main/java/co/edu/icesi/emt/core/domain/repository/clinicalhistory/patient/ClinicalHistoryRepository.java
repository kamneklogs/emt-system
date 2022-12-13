package co.edu.icesi.emt.core.domain.repository.clinicalhistory.patient;

import java.util.List;

import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;

public interface ClinicalHistoryRepository {

    void save(ClinicalHistory clinicalHistory);

    ClinicalHistory findLastByPatientId(String patientId);

    List<ClinicalHistory> findAllByPatientId(String patientId);
}
