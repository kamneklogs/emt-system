package co.edu.icesi.emt.core.domain.repository.pacient;

import java.util.List;

import co.edu.icesi.emt.core.domain.model.pacient.Pacient;
import co.edu.icesi.emt.core.domain.model.pacient.PacientPreview;

public interface PacientRepository {

    Pacient findById(String id);

    void save(Pacient pacient);

    void delete(String id);

    void update(Pacient pacient);

    List<PacientPreview> findAll();

}
