package co.edu.icesi.emt.core.domain.repository.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.personalinformation.CivilStatus;
import co.edu.icesi.emt.core.domain.model.personalinformation.Gender;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.repository.PersonalInformationRepository;

@Repository
public class PersonalInformationRepositoryImpl implements PersonalInformationRepository {

    private static final String PERSONAL_INFORMATION_TABLE = "personal_information";

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String BIRTH_DATE = "dob";
    private static final String GENDER = "gender";
    private static final String CIVIL_STATUS = "civil_status";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String ADDRESS = "address";

    private static final String PERSONAL_INFORMATION_COLUM = ID + ", " + FIRST_NAME + ", " + LAST_NAME + ", " + EMAIL
            + ", " +
            BIRTH_DATE + ", " + GENDER + ", " + CIVIL_STATUS + ", " + PHONE_NUMBER + ", " + ADDRESS;

    private static final String SELECT_FROM_PERSONAL_INFORMATION = "SELECT " + PERSONAL_INFORMATION_COLUM + " FROM "
            + PERSONAL_INFORMATION_TABLE;

    private static final String SELECT_FROM_PERSONAL_INFORMATION_BY_ID = SELECT_FROM_PERSONAL_INFORMATION
            + " WHERE " + ID + " = ?";

    private static final String DELETE_FROM_PERSONAL_INFORMATION_WHERE_ID = "DELETE FROM " + PERSONAL_INFORMATION_TABLE
            + " WHERE " + ID + " = ?";

    private static final String INSERT_INTO_PERSONAL_INFORMATION = "INSERT INTO " + PERSONAL_INFORMATION_TABLE + " ("
            + PERSONAL_INFORMATION_COLUM
            + ") VALUES (?,?,?,?,?,?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonalInformationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PersonalInformation findById(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_FROM_PERSONAL_INFORMATION_BY_ID, this::parse, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<PersonalInformation> findAll() {
        try {
            return jdbcTemplate.query(SELECT_FROM_PERSONAL_INFORMATION,
                    this::parse);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void save(PersonalInformation personalInformation) {
        jdbcTemplate.update(
                INSERT_INTO_PERSONAL_INFORMATION,
                personalInformation.getId(),
                personalInformation.getFirstName(),
                personalInformation.getLastName(),
                personalInformation.getEmail(),
                personalInformation.getBirthDate(),
                personalInformation.getGender().getId(),
                personalInformation.getCivilStatus().getId(),
                personalInformation.getPhoneNumber(),
                personalInformation.getAddress());

    }

    @Override
    public void delete(String id) {
        jdbcTemplate.update(DELETE_FROM_PERSONAL_INFORMATION_WHERE_ID, id);
    }

    @Override
    public void update(PersonalInformation personalInformation) {
        // TODO Auto-generated method stub
    }

    private PersonalInformation parse(final ResultSet rs, final int rowNum) throws SQLException {
        final String id = rs.getString(ID);
        final String firstName = rs.getString(FIRST_NAME);
        final String lastName = rs.getString(LAST_NAME);
        final String email = rs.getString(EMAIL);
        final Instant birthDate = rs.getTimestamp(BIRTH_DATE).toInstant();
        final Gender gender = Gender.findById(rs.getInt(GENDER));
        final CivilStatus civilStatus = CivilStatus.findById(rs.getInt(CIVIL_STATUS));
        final String phoneNumber = rs.getString(PHONE_NUMBER);
        final String address = rs.getString(ADDRESS);

        return new PersonalInformation(id, firstName, lastName, email, birthDate, gender, civilStatus, phoneNumber,
                address);
    }
}
