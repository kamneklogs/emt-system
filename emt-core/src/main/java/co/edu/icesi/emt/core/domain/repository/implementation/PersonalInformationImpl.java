package co.edu.icesi.emt.core.domain.repository.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.edu.icesi.emt.core.domain.model.personalinformation.CivilStatus;
import co.edu.icesi.emt.core.domain.model.personalinformation.Gender;
import co.edu.icesi.emt.core.domain.model.personalinformation.PersonalInformation;
import co.edu.icesi.emt.core.domain.repository.PersonalInformationRepository;

@Repository
public class PersonalInformationImpl implements PersonalInformationRepository {

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

    private static final String SELECT_FROM_PERSONAL_INFORMATION_BY_ID = "SELECT " + PERSONAL_INFORMATION_COLUM
            + " FROM " + PERSONAL_INFORMATION_TABLE + " WHERE " + ID + " = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonalInformationImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PersonalInformation findById(String id) {
        return jdbcTemplate.queryForObject(SELECT_FROM_PERSONAL_INFORMATION_BY_ID, this::parse, id);
    }

    @Override
    public void save(PersonalInformation personalInformation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

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
        final Gender gender = Gender.findById(rs.getString(GENDER));
        final CivilStatus civilStatus = CivilStatus.findById(rs.getString(CIVIL_STATUS));
        final String phoneNumber = rs.getString(PHONE_NUMBER);
        final String address = rs.getString(ADDRESS);

        return new PersonalInformation(id, firstName, lastName, email, birthDate, gender, civilStatus, phoneNumber,
                address);
    }
}
