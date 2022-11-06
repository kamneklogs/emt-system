package co.edu.icesi.emt.core.domain.model.patient.diseasehistorial;

import co.edu.icesi.emt.core.domain.model.disease.Disease;

public class DiseaseHistorial {

    private Disease firstDisease;
    private Disease secondDisease;
    private Disease thirdDisease;
    private Disease fourthDisease;

    public DiseaseHistorial(Disease firstDisease, Disease secondDisease, Disease thirdDisease,
            Disease fourthDisease) {
        this.firstDisease = firstDisease;
        this.secondDisease = secondDisease;
        this.thirdDisease = thirdDisease;
        this.fourthDisease = fourthDisease;
    }
}
