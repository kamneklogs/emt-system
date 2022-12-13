package co.edu.icesi.emt.core.application.controller.admission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.application.dto.patient.admission.AdmissionInformationDTO;
import co.edu.icesi.emt.core.application.dto.patient.admission.AdmissionInformationRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;
import co.edu.icesi.emt.core.domain.service.addmission.AdmissionService;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    private final AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @GetMapping("/{patientId}/last")
    public ResponseEntity<AdmissionInformationRetrievalDTO> findLastAdmission(
            @PathVariable("patientId") String patientId) {

        AdmissionInformation admissions = this.admissionService.findLastAdmissionByPatientId(patientId);

        if (admissions == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                AdmissionInformationRetrievalDTO.from(admissions));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<AdmissionInformationRetrievalDTO>> findAllAdmissionsByPatientId(
            @PathVariable("patientId") String patientId) {

        List<AdmissionInformation> admissions = this.admissionService.findAllAdmissionsByPatientId(patientId);

        if (admissions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                AdmissionInformationRetrievalDTO.from(admissions));
    }

    @PostMapping
    public ResponseEntity<AdmissionInformationRetrievalDTO> save(
            @RequestBody AdmissionInformationDTO admissionInformation) {
        this.admissionService.save(AdmissionInformationDTO.fromDTO(admissionInformation));
        return ResponseEntity.ok(AdmissionInformationRetrievalDTO.from(this.admissionService
                .findLastAdmissionByPatientId(admissionInformation.getPatientId())));
    }
}
