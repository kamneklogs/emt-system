package co.edu.icesi.emt.core.domain.repository.admission;

import java.util.List;

import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;

public interface AdmissionRepository {

    public void save(AdmissionInformation admissionInformation);

    public AdmissionInformation findLastAdmissionByPatientId(String patientId);

    public AdmissionInformation findById(int admissionId);

    public List<AdmissionInformation> findAllAdmissionsByPatientId(String patientId);
}
