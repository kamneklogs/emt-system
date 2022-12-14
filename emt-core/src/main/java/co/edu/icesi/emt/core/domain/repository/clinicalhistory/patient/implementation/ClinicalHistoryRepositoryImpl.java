package co.edu.icesi.emt.core.domain.repository.clinicalhistory.patient.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.clinicalhistory.patient.ClinicalHistory;
import co.edu.icesi.emt.core.domain.repository.clinicalhistory.patient.ClinicalHistoryRepository;

@Repository
public class ClinicalHistoryRepositoryImpl implements ClinicalHistoryRepository {

    private static final String CLINICAL_HISTORY_TABLE = "clinical_history";

    private static final String ID = "id";
    private static final String PATIENT_ID = "patient_id";
    private static final String DOCTOR_ID = "doctor_id";
    private static final String CREATED_AT = "created_at";
    private static final String CLINICAL_HISTORY_FORMAT_ID = "clinical_history_format_id";
    private static final String PAYLOAD = "payload";

    private static final String CLINICAL_HISTORY_INSERT_COLUMNS = PATIENT_ID + ", " + DOCTOR_ID + ", "
            + CLINICAL_HISTORY_FORMAT_ID + ", " + PAYLOAD;

    public static final String CLINICAL_HISTORY_COLUMNS = ID + ", " + PATIENT_ID + ", " + DOCTOR_ID + ", " + CREATED_AT
            + ", "
            + CLINICAL_HISTORY_FORMAT_ID + ", " + PAYLOAD;

    private static final String INSERT_INTO_CLINICAL_HISTORY = "INSERT INTO " + CLINICAL_HISTORY_TABLE + " ("
            + CLINICAL_HISTORY_INSERT_COLUMNS + ") VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_CLINICAL_HISTORIES_BY_PATIENT_ID = "SELECT " + CLINICAL_HISTORY_COLUMNS
            + " FROM " + CLINICAL_HISTORY_TABLE + " WHERE " + PATIENT_ID + " = ? ORDER BY " + CREATED_AT
            + " DESC";

    private static final String SELECT_LAST_CLINICAL_HISTORY_BY_PATIENT_ID = "SELECT " + CLINICAL_HISTORY_COLUMNS
            + " FROM " + CLINICAL_HISTORY_TABLE + " WHERE " + PATIENT_ID + " = ? ORDER BY " + CREATED_AT
            + " DESC LIMIT 1";

    private static final String SELECT_CLINICAL_HISTORY_BY_ID = "SELECT " + CLINICAL_HISTORY_COLUMNS
            + " FROM " + CLINICAL_HISTORY_TABLE + " WHERE " + ID + " = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClinicalHistoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(ClinicalHistory clinicalHistory) {
        jdbcTemplate.update(INSERT_INTO_CLINICAL_HISTORY, clinicalHistory.getPatientId(),
                clinicalHistory.getDoctorId(),
                clinicalHistory.getClinicalHistoryFormatId(),
                clinicalHistory.getPayload());
    }

    @Override
    public ClinicalHistory findLastByPatientId(String patientId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_LAST_CLINICAL_HISTORY_BY_PATIENT_ID,
                    this::parse, patientId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public ClinicalHistory findById(int clinicalHistoryId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CLINICAL_HISTORY_BY_ID,
                    this::parse, clinicalHistoryId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<ClinicalHistory> findAllByPatientId(String patientId) {
        try {
            return jdbcTemplate.query(SELECT_ALL_CLINICAL_HISTORIES_BY_PATIENT_ID,
                    this::parse, patientId);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    private ClinicalHistory parse(final ResultSet rs, final int rowNum) throws SQLException {
        return new ClinicalHistory(rs.getInt(ID),
                rs.getString(PATIENT_ID),
                rs.getString(DOCTOR_ID),
                rs.getTimestamp(CREATED_AT).toInstant(),
                rs.getInt(CLINICAL_HISTORY_FORMAT_ID),
                rs.getString(PAYLOAD));
    }
}
