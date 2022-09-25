package co.edu.icesi.emt.core.domain.service.pacient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.core.domain.model.pacient.Pacient;
import co.edu.icesi.emt.core.domain.model.pacient.PacientPreview;
import co.edu.icesi.emt.core.domain.repository.pacient.PacientRepository;
import co.edu.icesi.emt.core.domain.repository.pacient.implementation.PacientRepositoryImpl;

@Service
public class PacientService {

    private final PacientRepository pacientRepository;

    @Autowired
    public PacientService(PacientRepositoryImpl pacientRepositoryImpl) {
        this.pacientRepository = pacientRepositoryImpl;
    }

    public Pacient findPacientById(String id) {
        return this.pacientRepository.findById(id);
    }

    public List<PacientPreview> findAll() {
        return this.pacientRepository.findAll();
    }
}
