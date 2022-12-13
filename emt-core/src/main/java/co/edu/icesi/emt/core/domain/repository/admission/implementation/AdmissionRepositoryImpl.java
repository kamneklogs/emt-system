package co.edu.icesi.emt.core.domain.repository.admission.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.patient.admission.AdmissionInformation;
import co.edu.icesi.emt.core.domain.repository.admission.AdmissionRepository;

@Repository
public class AdmissionRepositoryImpl implements AdmissionRepository {

    private static final String ADMISSION_TABLE = "admission";

    private static final String ID = "id";
    private static final String PATIENT_ID = "patient_id";
    private static final String CARETAKER = "caretaker";
    private static final String CARETAKER_PHONE_NUMBER = "caretaker_phone_number";
    private static final String ADMISSION_DATE = "admission_date";
    private static final String MEDICAL_CONSULTATION_REASON = "medical_consultation_reason";

    private static final String ADMISSION_INSERT_COLUMNS = PATIENT_ID + ", " + CARETAKER + ", "
            + CARETAKER_PHONE_NUMBER + ", " + ADMISSION_DATE + ", " + MEDICAL_CONSULTATION_REASON;

    public static final String ADMISSION_COLUMNS = ID + ", " + ADMISSION_INSERT_COLUMNS;

    private static final String INSERT_INTO_ADMISSION = "INSERT INTO " + ADMISSION_TABLE + " ("
            + ADMISSION_INSERT_COLUMNS + ") VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_ADMISSIONS_BY_PATIENT_ID = "SELECT " + ADMISSION_COLUMNS
            + " FROM " + ADMISSION_TABLE + " WHERE " + PATIENT_ID + " = ? ORDER BY " + ADMISSION_DATE
            + " DESC";

    private static final String SELECT_LAST_ADMISSION_BY_PATIENT_ID = "SELECT " + ADMISSION_COLUMNS
            + " FROM " + ADMISSION_TABLE + " WHERE " + PATIENT_ID + " = ? ORDER BY " + ADMISSION_DATE
            + " DESC LIMIT 1";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdmissionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(AdmissionInformation admissionInformation) {
        jdbcTemplate.update(INSERT_INTO_ADMISSION, admissionInformation.getPatientId(),
                admissionInformation.getCaretaker(), admissionInformation.getCaretakerPhoneNumber(),
                Timestamp.from(admissionInformation.getAdmissionDate()),
                admissionInformation.getMedicalConsultationReason());
    }

    @Override
    public AdmissionInformation findLastAdmissionByPatientId(String patientId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_LAST_ADMISSION_BY_PATIENT_ID,
                    this::parse, patientId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<AdmissionInformation> findAllAdmissionsByPatientId(String patientId) {
        try {
            return jdbcTemplate.query(SELECT_ALL_ADMISSIONS_BY_PATIENT_ID,
                    this::parse, patientId);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    private AdmissionInformation parse(final ResultSet rs, final int rowNum) throws SQLException {
        AdmissionInformation admissionInformation = new AdmissionInformation(
                rs.getInt(ID),
                rs.getString(PATIENT_ID), rs.getString(CARETAKER),
                rs.getString(CARETAKER_PHONE_NUMBER), rs.getTimestamp(ADMISSION_DATE).toInstant(),
                rs.getString(MEDICAL_CONSULTATION_REASON));
        return admissionInformation;
    }
}
