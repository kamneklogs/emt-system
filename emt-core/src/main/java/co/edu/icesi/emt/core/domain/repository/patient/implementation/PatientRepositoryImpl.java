package co.edu.icesi.emt.core.domain.repository.patient.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.patient.Patient;
import co.edu.icesi.emt.core.domain.model.patient.PatientPreview;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformationPreview;
import co.edu.icesi.emt.core.domain.repository.patient.PatientRepository;
import co.edu.icesi.emt.core.domain.service.personalinformation.PersonalInformationService;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    private static final String PATIENT_TABLE = "patient";

    private static final String ID = "id";
    private static final String CREATION_DATE = "creation_date";

    private static final String PATIENT_COLUMNS = ID + ", " + CREATION_DATE;

    private static final String SELECT_ALL = "SELECT " + PATIENT_COLUMNS + " FROM " + PATIENT_TABLE;
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";

    private final JdbcTemplate jdbcTemplate;
    private final PersonalInformationService personalInformationService;

    @Autowired
    public PatientRepositoryImpl(JdbcTemplate jdbcTemplate, PersonalInformationService personalInformationService) {
        this.jdbcTemplate = jdbcTemplate;
        this.personalInformationService = personalInformationService;
    }

    @Override
    public Patient findById(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BY_ID,
                    this::parse);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Patient patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Patient patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PatientPreview> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL,
                    this::parsePreview);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private Patient parse(final ResultSet rs, final int rowNum) throws SQLException {

        String id = rs.getString(ID);
        Instant creationDate = rs.getTimestamp(CREATION_DATE).toInstant();
        PersonalInformation personalInformation = personalInformationService.findById(id);

        return new Patient(id, creationDate, personalInformation);
    }

    private PatientPreview parsePreview(final ResultSet rs, final int rowNum) throws SQLException {

        String id = rs.getString(ID);
        Instant creationDate = rs.getTimestamp(CREATION_DATE).toInstant();
        PersonalInformationPreview personalInformation = personalInformationService.findPreviewById(id);

        return new PatientPreview(id, creationDate, personalInformation);
    }
}
