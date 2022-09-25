package co.edu.icesi.emt.core.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformationPreview;
import co.edu.icesi.emt.core.domain.repository.PersonalInformationRepository;
import co.edu.icesi.emt.core.domain.repository.implementation.PersonalInformationRepositoryImpl;

@Service
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    @Autowired
    public PersonalInformationService(PersonalInformationRepositoryImpl personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public PersonalInformation findById(String id) {
        return this.personalInformationRepository.findById(id);
    }

    public List<PersonalInformationPreview> findAll() {
        return this.personalInformationRepository.findAll();
    }

    public void save(PersonalInformation personalInformation) {
        this.personalInformationRepository.save(personalInformation);
    }

    public void deleteById(String id) {
        this.personalInformationRepository.delete(id);
    }
}
