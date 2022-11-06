package co.edu.icesi.emt.core.domain.repository.patient.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.patient.Patient;
import co.edu.icesi.emt.core.domain.model.patient.PatientPreview;
import co.edu.icesi.emt.core.domain.repository.patient.PatientRepository;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    private static final String PATIENT_TABLE = "patient";

    private static final String ID = "id";
    private static final String CREATION_DATE = "creation_date";

    private static final String PATIENT_COLUMNS = ID + ", " + CREATION_DATE;

    private static final String SELECT_ALL = "SELECT " + PATIENT_COLUMNS + " FROM " + PATIENT_TABLE;
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";

    private static final String INSERT_INTO_PATIENT = "INSERT INTO " + PATIENT_TABLE + " (" + PATIENT_COLUMNS
            + ") VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Patient findById(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BY_ID,
                    this::parse, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Patient patient) {
        jdbcTemplate.update(INSERT_INTO_PATIENT, patient.getId(), Timestamp.from(patient.getCreationDate()));
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

        return new Patient(id, creationDate);
    }

    private PatientPreview parsePreview(final ResultSet rs, final int rowNum) throws SQLException {
        String id = rs.getString(ID);
        Instant creationDate = rs.getTimestamp(CREATION_DATE).toInstant();

        return new PatientPreview(id, creationDate);
    }
}
