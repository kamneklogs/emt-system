package co.edu.icesi.emt.core.application.controller.personalinformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationCreationDTO;
import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.service.PersonalInformationService;

@RestController
@RequestMapping("/personalinformation")
public class PersonalInformationController {

    private final PersonalInformationService personalInformationService;

    @Autowired
    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalInformationRetrievalDTO>> findAll() {
        return ResponseEntity.ok(PersonalInformationRetrievalDTO.from(personalInformationService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformationRetrievalDTO> findById(@PathVariable("id") String id) {
        PersonalInformation personalInformation = personalInformationService.findById(id);

        if (personalInformation == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(PersonalInformationRetrievalDTO.from(personalInformation));
    }

    @PostMapping
    public ResponseEntity<PersonalInformationRetrievalDTO> save(
            PersonalInformationCreationDTO personalInformationCreationDTO) {
        personalInformationService.save(PersonalInformationCreationDTO.fromDTO(personalInformationCreationDTO));

        return ResponseEntity.ok().build();
    }
}
