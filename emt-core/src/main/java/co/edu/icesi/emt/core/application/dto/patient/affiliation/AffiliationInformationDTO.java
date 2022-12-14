package co.edu.icesi.emt.core.application.dto.patient.affiliation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.domain.model.patient.affiliation.AffiliationInformation;

public class AffiliationInformationDTO {

    private final String medicalEntity;
    private final String healthRegime;
    private final String benefitPlan;
    private final String socialStratum;

    @JsonCreator
    public AffiliationInformationDTO(@JsonProperty("medicalEntity") String medicalEntity,
            @JsonProperty("healthRegime") String healthRegime, @JsonProperty("benefitPlan") String benefitPlan,
            @JsonProperty("socialStratum") String socialStratum) {
        this.medicalEntity = medicalEntity;
        this.healthRegime = healthRegime;
        this.benefitPlan = benefitPlan;
        this.socialStratum = socialStratum;
    }

    public String getMedicalEntity() {
        return medicalEntity;
    }

    public String getHealthRegime() {
        return healthRegime;
    }

    public String getBenefitPlan() {
        return benefitPlan;
    }

    public String getSocialStratum() {
        return socialStratum;
    }

    public static AffiliationInformation fromDTO(AffiliationInformationDTO affiliationInformation) {
        return new AffiliationInformation(affiliationInformation.getMedicalEntity(),
                affiliationInformation.getHealthRegime(), affiliationInformation.getBenefitPlan(),
                affiliationInformation.getSocialStratum());
    }

    public static AffiliationInformationDTO from(AffiliationInformation affiliationInformation) {
        return new AffiliationInformationDTO(affiliationInformation.getMedicalEntity(),
                affiliationInformation.getHealthRegime(), affiliationInformation.getBenefitPlan(),
                affiliationInformation.getSocialStratum());
    }
}
