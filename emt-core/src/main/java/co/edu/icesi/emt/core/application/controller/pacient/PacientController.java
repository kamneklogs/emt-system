package co.edu.icesi.emt.core.application.controller.pacient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.application.dto.pacient.PacientPreviewDTO;
import co.edu.icesi.emt.core.application.dto.pacient.PacientRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.pacient.Pacient;
import co.edu.icesi.emt.core.domain.model.pacient.PacientPreview;
import co.edu.icesi.emt.core.domain.service.pacient.PacientService;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    private final PacientService pacientService;

    @Autowired
    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public ResponseEntity<List<PacientPreviewDTO>> findAll() {

        List<PacientPreview> pacientPreviews = this.pacientService.findAll();

        return ResponseEntity.ok(PacientPreviewDTO.from(pacientPreviews));
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientRetrievalDTO> findById(String id) {

        Pacient pacient = this.pacientService.findPacientById(id);

        return ResponseEntity.ok(PacientRetrievalDTO.from(pacient));
    }
}
