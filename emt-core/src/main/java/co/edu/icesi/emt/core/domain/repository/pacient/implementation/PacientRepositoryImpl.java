package co.edu.icesi.emt.core.domain.repository.pacient.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.pacient.Pacient;
import co.edu.icesi.emt.core.domain.model.pacient.PacientPreview;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformationPreview;
import co.edu.icesi.emt.core.domain.repository.pacient.PacientRepository;
import co.edu.icesi.emt.core.domain.service.personalinformation.PersonalInformationService;

@Repository
public class PacientRepositoryImpl implements PacientRepository {

    private static final String PACIENT_TABLE = "pacient";

    private static final String ID = "id";
    private static final String CREATION_DATE = "creation_date";

    private static final String PACIENT_COLUMNS = ID + ", " + CREATION_DATE;

    private static final String SELECT_ALL = "SELECT " + PACIENT_COLUMNS + " FROM " + PACIENT_TABLE;
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";

    private final JdbcTemplate jdbcTemplate;
    private final PersonalInformationService personalInformationService;

    @Autowired
    public PacientRepositoryImpl(JdbcTemplate jdbcTemplate, PersonalInformationService personalInformationService) {
        this.jdbcTemplate = jdbcTemplate;
        this.personalInformationService = personalInformationService;
    }

    @Override
    public Pacient findById(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BY_ID,
                    this::parse);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Pacient pacient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Pacient pacient) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PacientPreview> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL,
                    this::parsePreview);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private Pacient parse(final ResultSet rs, final int rowNum) throws SQLException {

        String id = rs.getString("id");
        Instant creationDate = rs.getTimestamp("creation_date").toInstant();
        PersonalInformation personalInformation = personalInformationService
                .findById(rs.getString("personal_information_id"));

        return new Pacient(id, creationDate, personalInformation);
    }

    private PacientPreview parsePreview(final ResultSet rs, final int rowNum) throws SQLException {

        String id = rs.getString("id");
        Instant creationDate = rs.getTimestamp("creation_date").toInstant();
        PersonalInformationPreview personalInformation = personalInformationService
                .findPreviewById(rs.getString("personal_information_id"));

        return new PacientPreview(id, creationDate, personalInformation);
    }
}
