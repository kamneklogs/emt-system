package co.edu.icesi.emt.core.domain.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.core.domain.model.patient.Patient;
import co.edu.icesi.emt.core.domain.model.patient.PatientPreview;
import co.edu.icesi.emt.core.domain.repository.patient.PatientRepository;
import co.edu.icesi.emt.core.domain.repository.patient.implementation.PatientRepositoryImpl;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepositoryImpl patientRepositoryImpl) {
        this.patientRepository = patientRepositoryImpl;
    }

    public Patient findById(String id) {
        return this.patientRepository.findById(id);
    }

    public List<PatientPreview> findAll() {
        return this.patientRepository.findAll();
    }
}
