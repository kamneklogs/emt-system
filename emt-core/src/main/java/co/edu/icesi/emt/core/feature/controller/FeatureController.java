package co.edu.icesi.emt.core.feature.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.core.feature.dto.FeatureDTO;
import co.edu.icesi.emt.core.feature.model.sections.Feature;

@RestController
@RequestMapping("/feature")
public class FeatureController {

    @GetMapping
    public ResponseEntity<FeatureDTO[]> getFeatures() {
        return ResponseEntity.ok(FeatureDTO.from(Feature.values()));
    }

    @GetMapping("/{name}/roles")
    public ResponseEntity<String[]> getRolesWithAccess(@PathVariable("name") String name) {
        Feature feauture = Feature.findByName(name);

        if (feauture == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(feauture.getRolesWithAccess());
    }
}
