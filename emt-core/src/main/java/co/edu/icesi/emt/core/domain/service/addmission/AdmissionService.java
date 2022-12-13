package co.edu.icesi.emt.core.domain.service.addmission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;
import co.edu.icesi.emt.core.domain.repository.admission.AdmissionRepository;
import co.edu.icesi.emt.core.domain.repository.admission.implementation.AdmissionRepositoryImpl;

@Service
public class AdmissionService {

    private AdmissionRepository admissionRepository;

    @Autowired
    public AdmissionService(AdmissionRepositoryImpl admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    public void save(AdmissionInformation admissionInformation) {
        this.admissionRepository.save(admissionInformation);
    }

    public AdmissionInformation findLastAdmissionByPatientId(String patientId) {
        return this.admissionRepository.findLastAdmissionByPatientId(patientId);
    }

    public AdmissionInformation findById(int admissionId) {
        return this.admissionRepository.findById(admissionId);
    }

    public List<AdmissionInformation> findAllAdmissionsByPatientId(String patientId) {
        return this.admissionRepository.findAllAdmissionsByPatientId(patientId);
    }
}
