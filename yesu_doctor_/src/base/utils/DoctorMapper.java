package base.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import base.models.Doctor;

public class DoctorMapper implements RowMapper<Doctor> {

	@Override
	public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {

		Doctor doctor = new Doctor();
		doctor.setDoctorid(resultSet.getInt("doctorid"));
		doctor.setFullname(resultSet.getString("fullname"));
		doctor.setSpecializationname(resultSet.getString("specializationname"));
		doctor.setQualification(resultSet.getString("qualification"));
		doctor.setExperience(resultSet.getByte("experience"));
		doctor.setDesignation(resultSet.getString("designation"));
		doctor.setPhoto(resultSet.getString("photo"));
		return doctor;
	}
}