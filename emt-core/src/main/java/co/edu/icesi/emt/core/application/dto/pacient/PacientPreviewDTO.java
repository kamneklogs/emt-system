package co.edu.icesi.emt.core.application.dto.pacient;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.core.application.dto.personalinformation.PersonalInformationPreviewDTO;
import co.edu.icesi.emt.core.domain.model.pacient.PacientPreview;

public class PacientPreviewDTO {

    private final String id;
    private final Instant creationDate;
    private final PersonalInformationPreviewDTO personalInformation;

    @JsonCreator
    public PacientPreviewDTO(@JsonProperty("id") String id, @JsonProperty("creationDate") Instant creationDate,
            @JsonProperty("personalInformation") PersonalInformationPreviewDTO personalInformation) {
        this.id = id;
        this.creationDate = creationDate;
        this.personalInformation = personalInformation;
    }

    public String getId() {
        return id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public PersonalInformationPreviewDTO getPersonalInformation() {
        return personalInformation;
    }

    public static PacientPreviewDTO from(PacientPreview pacientPreview) {
        return new PacientPreviewDTO(pacientPreview.getId(), pacientPreview.getCreationDate(),
                PersonalInformationPreviewDTO.from(pacientPreview.getPersonalInformation()));
    }

    public static List<PacientPreviewDTO> from(List<PacientPreview> pacientPreviews) {
        return pacientPreviews.stream().map(PacientPreviewDTO::from).toList();
    }
}
