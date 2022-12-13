package co.edu.icesi.emt.core.domain.model.patient.affiliation;

public class AffiliationInformation {

    private final String medicalEntity;
    private final String healthRegime;
    private final String benefitPlan;
    private final String socialStratum;

    public AffiliationInformation(String medicalEntity, String healthRegime, String benefitPlan, String socialStratum) {
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
}
