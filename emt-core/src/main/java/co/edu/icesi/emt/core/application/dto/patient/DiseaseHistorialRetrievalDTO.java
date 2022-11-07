package co.edu.icesi.emt.core.application.dto.patient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.application.dto.disease.DiseaseRetrievalDTO;
import co.edu.icesi.emt.core.domain.model.patient.diseasehistorial.DiseaseHistorial;

public class DiseaseHistorialRetrievalDTO {
    private final DiseaseRetrievalDTO firstDisease;
    private final DiseaseRetrievalDTO secondDisease;
    private final DiseaseRetrievalDTO thirdDisease;
    private final DiseaseRetrievalDTO fourthDisease;

    @JsonCreator
    public DiseaseHistorialRetrievalDTO(@JsonProperty("firstDisease") DiseaseRetrievalDTO firstDisease,
            @JsonProperty("secondDisease") DiseaseRetrievalDTO secondDisease,
            @JsonProperty("thirdDisease") DiseaseRetrievalDTO thirdDisease,
            @JsonProperty("fourthDisease") DiseaseRetrievalDTO fourthDisease) {
        this.firstDisease = firstDisease;
        this.secondDisease = secondDisease;
        this.thirdDisease = thirdDisease;
        this.fourthDisease = fourthDisease;
    }

    public DiseaseRetrievalDTO getFirstDisease() {
        return firstDisease;
    }

    public DiseaseRetrievalDTO getSecondDisease() {
        return secondDisease;
    }

    public DiseaseRetrievalDTO getThirdDisease() {
        return thirdDisease;
    }

    public DiseaseRetrievalDTO getFourthDisease() {
        return fourthDisease;
    }

    public static DiseaseHistorialRetrievalDTO from(DiseaseHistorial diseaseHistorial) {
        return new DiseaseHistorialRetrievalDTO(
                DiseaseRetrievalDTO.from(diseaseHistorial.getFirstDisease()),
                DiseaseRetrievalDTO.from(diseaseHistorial.getSecondDisease()),
                DiseaseRetrievalDTO.from(diseaseHistorial.getThirdDisease()),
                DiseaseRetrievalDTO.from(diseaseHistorial.getFourthDisease()));
    }
}
