package co.edu.icesi.emt.core.application.controller.clinicalhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.application.dto.clinicalhistory.patient.ClinicalHistoryCreationDTO;
import co.edu.icesi.emt.core.application.dto.clinicalhistory.patient.ClinicalHistoryRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;
import co.edu.icesi.emt.core.domain.service.clinicalhistory.patient.ClinicalHistoryService;

@RestController
@RequestMapping("/clinicalhistory")
public class ClinicalHistoryController {

    private final ClinicalHistoryService clinicalHistoryService;

    @Autowired
    public ClinicalHistoryController(ClinicalHistoryService clinicalHistoryService) {
        this.clinicalHistoryService = clinicalHistoryService;
    }

    @GetMapping("/{patientId}/last")
    public ResponseEntity<ClinicalHistoryRetrievalDTO> getLastClinicalHistoryByPatientId(
            @PathVariable("patientId") String patientId) {
        ClinicalHistory lastClinicalHistory = clinicalHistoryService.findLastByPatientId(patientId);

        if (lastClinicalHistory == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(ClinicalHistoryRetrievalDTO.from(lastClinicalHistory));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<ClinicalHistoryRetrievalDTO>> getAllClinicalHistoryByPatientId(
            @PathVariable("patientId") String patientId) {
        return ResponseEntity
                .ok(ClinicalHistoryRetrievalDTO.from(clinicalHistoryService.findAllByPatientId(patientId)));
    }

    @PostMapping
    public ResponseEntity<ClinicalHistoryRetrievalDTO> saveClinicalHistory(
            @RequestBody ClinicalHistoryCreationDTO clinicalHistoryCreation) {
        clinicalHistoryService.save(ClinicalHistoryCreationDTO.fromDTO(clinicalHistoryCreation));

        return ResponseEntity
                .ok(ClinicalHistoryRetrievalDTO
                        .from(clinicalHistoryService.findLastByPatientId(clinicalHistoryCreation.getPatientId())));
    }

    @GetMapping("/id/{clinicalHistoryFormatId}")
    public ResponseEntity<ClinicalHistoryRetrievalDTO> getClinicalHistoryByClinicalHistoryFormatId(
            @PathVariable("clinicalHistoryFormatId") int clinicalHistoryFormatId) {
        ClinicalHistory clinicalHistory = clinicalHistoryService
                .findById(clinicalHistoryFormatId);

        if (clinicalHistory == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(ClinicalHistoryRetrievalDTO.from(clinicalHistory));
    }
}
