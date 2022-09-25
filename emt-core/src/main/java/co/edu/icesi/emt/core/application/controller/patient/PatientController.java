package co.edu.icesi.emt.core.application.controller.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.application.dto.patient.PatientPreviewDTO;
import co.edu.icesi.emt.core.application.dto.patient.PatientRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.patient.Patient;
import co.edu.icesi.emt.core.domain.model.patient.PatientPreview;
import co.edu.icesi.emt.core.domain.service.patient.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientPreviewDTO>> findAll() {

        List<PatientPreview> patientPreviews = this.patientService.findAll();

        return ResponseEntity.ok(PatientPreviewDTO.from(patientPreviews));
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientRetrievalDTO> findById(String id) {

        Patient patient = this.patientService.findById(id);

        return ResponseEntity.ok(PatientRetrievalDTO.from(patient));
    }
}
