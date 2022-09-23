package co.edu.icesi.emt.core.domain.repository;

import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;

public interface PersonalInformationRepository {

    PersonalInformation findById(String id);

    void save(PersonalInformation personalInformation);

    void delete(String id);

    void update(PersonalInformation personalInformation);

}
