package base.utils;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import base.models.Patient;

public class PatientMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setPatientId(resultSet.getInt("patient_id"));
        patient.setName(resultSet.getString("name"));
        patient.setGender(resultSet.getString("gender"));
        patient.setPhone(resultSet.getString("phone"));
        patient.setAge(resultSet.getInt("age"));
        return patient;
    }
}
