package co.edu.icesi.emt.core.domain.service.clinicalhistory.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;
import co.edu.icesi.emt.core.domain.repository.clinicalhistory.patient.ClinicalHistoryRepository;
import co.edu.icesi.emt.core.domain.repository.clinicalhistory.patient.implementation.ClinicalHistoryRepositoryImpl;

@Service
public class ClinicalHistoryService {

    private final ClinicalHistoryRepository clinicalHistoryRepository;

    @Autowired
    public ClinicalHistoryService(ClinicalHistoryRepositoryImpl clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    public void save(ClinicalHistory clinicalHistory) {
        this.clinicalHistoryRepository.save(clinicalHistory);
    }

    public ClinicalHistory findLastByPatientId(String patientId) {
        return this.clinicalHistoryRepository.findLastByPatientId(patientId);
    }

    public ClinicalHistory findById(int clinicalHistoryId) {
        return this.clinicalHistoryRepository.findById(clinicalHistoryId);
    }

    public List<ClinicalHistory> findAllByPatientId(String patientId) {
        return this.clinicalHistoryRepository.findAllByPatientId(patientId);
    }
}
