package co.edu.icesi.emt.core.domain.service.patient;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.emt.core.domain.model.patient.Patient;
import co.edu.icesi.emt.core.domain.model.patient.PatientPreview;
import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;
import co.edu.icesi.emt.core.domain.repository.patient.PatientRepository;
import co.edu.icesi.emt.core.domain.repository.patient.implementation.PatientRepositoryImpl;
import co.edu.icesi.emt.core.domain.service.addmission.AdmissionService;
import co.edu.icesi.emt.core.domain.service.personalinformation.PersonalInformationService;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PersonalInformationService personalInformationService;
    private final AdmissionService admissionService;

    @Autowired
    public PatientService(PatientRepositoryImpl patientRepositoryImpl,
            PersonalInformationService personalInformationService,
            AdmissionService admissionService) {
        this.patientRepository = patientRepositoryImpl;
        this.personalInformationService = personalInformationService;
        this.admissionService = admissionService;
    }

    public Patient findById(String id) {
        Patient patient = this.patientRepository.findById(id);
        patient.setPersonalInformation(this.personalInformationService.findById(id));
        return patient;
    }

    public List<PatientPreview> findAll() {

        List<PatientPreview> patients = this.patientRepository.findAll();

        patients.forEach(patient -> {
            patient.setPersonalInformation(
                    this.personalInformationService.findPreviewById(patient.getId()));
        });
        return patients;
    }

    @Transactional
    public void save(Patient patient) {
        if (this.personalInformationService.existsById(patient.getId())) {
            this.personalInformationService.update(patient.getPersonalInformation());
        } else {
            this.personalInformationService.save(patient.getPersonalInformation());
        }

        patient.setCreationDate(patient.getCreationDate() == null ? Instant.now() : patient.getCreationDate());
        this.patientRepository.save(patient);
    }

    @Transactional
    public void save(Patient patient, AdmissionInformation admissionInformation) {
        if (this.personalInformationService.existsById(patient.getId())) {
            this.personalInformationService.update(patient.getPersonalInformation());
        } else {
            this.personalInformationService.save(patient.getPersonalInformation());
        }

        patient.setCreationDate(patient.getCreationDate() == null ? Instant.now() : patient.getCreationDate());
        this.patientRepository.save(patient);

        this.admissionService.save(admissionInformation);
    }

    @Transactional
    public void update(Patient patient) {
        if (this.personalInformationService.existsById(patient.getId())) {
            this.personalInformationService.update(patient.getPersonalInformation());
        } else {
            this.personalInformationService.save(patient.getPersonalInformation());
        }

        this.patientRepository.update(patient);
    } 
}
