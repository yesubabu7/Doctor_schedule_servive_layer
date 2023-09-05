package base.dals;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import base.daos.DoctorDetailsDAO;
import base.models.AppointmentSchedule;
import base.models.Doctor;
import base.utils.AppointmentScheduleMapper;
import base.utils.DoctorMapper;

public class DoctorDetailsDAL implements DoctorDetailsDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_DOCTOR = "select \r\n"
			+ "d.doctorid, d.fullname,d.photo,d.designation, d.qualification, d.experience, s.specializationname\r\n"
			+ "from \r\n" + "	doctor d, \r\n" + "	specialization s\r\n" + "where \r\n"
			+ "	(s.specializationid = d.specializationid) and doctorid = ?";

	private final String SQL_GET_ALL_DOCTORS = "select \r\n"
			+ "d.doctorid, d.fullname,d.photo,d.designation, d.qualification, d.experience, s.specializationname\r\n"
			+ "from \r\n" + "	doctor d, \r\n" + "	specialization s\r\n" + "where \r\n"
			+ "	(s.specializationid = d.specializationid)";

	private final String SQL_GET_ALL_DOCTORS_BY_SPECIALIZATION = "select \r\n"
			+ "d.doctorid, d.fullname,d.photo,d.designation, d.qualification, d.experience, s.specializationname\r\n"
			+ "from \r\n" + "	doctor d, \r\n" + "	specialization s\r\n" + "where \r\n"
			+ "	(s.specializationid = d.specializationid)" + " and " + " (s.specializationname = ?)";

	private final String SQL_DOCTOR_SCHEDULE = "select * from appointmentsslotcalendar where slotdoctorid = ?";
	private final String SQL_GET_ALL_SPECIALIZATIONS = "select specializationname from specialization";

	@Autowired
	public DoctorDetailsDAL(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Doctor> getAllDoctorsInfo() {
		return jdbcTemplate.query(SQL_GET_ALL_DOCTORS, new DoctorMapper());
	}

	@Override
	public List<Doctor> getAllDoctorsBySpecialization(String specialization) {
		return jdbcTemplate.query(SQL_GET_ALL_DOCTORS_BY_SPECIALIZATION, new Object[] { specialization },
				new DoctorMapper());
	}

	@Override
	public Doctor getDoctorInfoById(int docid) {
		
		return jdbcTemplate.queryForObject(SQL_FIND_DOCTOR, new Object[] { docid }, new DoctorMapper());
	}

	@Override
	public List<AppointmentSchedule> getAppointmentScheduleById(int docid) {
		return jdbcTemplate.query(SQL_DOCTOR_SCHEDULE, new Object[] { docid }, new AppointmentScheduleMapper());
	}

	@Override
	public List<Map<String, Object>> getAllSpecializations() {
		return jdbcTemplate.queryForList(SQL_GET_ALL_SPECIALIZATIONS);
	}

	@Override
	public boolean updateStatus(String selectedSlot)
	{
		int slotId=Integer.parseInt(selectedSlot);
		String sql="update appointmentsslotcalendar set slotstatus='booked' where slotid=?";
		
		int i=jdbcTemplate.update(sql,slotId);
		if(i>0) {
			System.out.println("Occured"+i);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Doctor> doctorDetails(int id) {
		String sql="SELECT d.*, s.specializationname\r\n"
				+ "FROM Doctor AS d\r\n"
				+ "INNER JOIN specialization AS s ON d.specializationid = s.specializationid\r\n"
				+ "WHERE d.doctorid = ?";
		
		return jdbcTemplate.query(sql, new Object[] { id }, new DoctorMapper());

		
	}

	@Override
	public List<AppointmentSchedule> timeSlots(int id) {
		String sql="select * from appointmentsslotcalendar where slotid=?";
		return jdbcTemplate.query(sql, new Object[] { id }, new AppointmentScheduleMapper());
 
		
	}

	public boolean patientDetails_dals(int doctorId, int parseInt, String name, String gender, String phone, int age) {
	    
	        // Define your SQL INSERT query
	        String sql = "INSERT INTO doctor_schedule_patient (patient_id,doctor_id, patient_name, gender, phone, age) VALUES (?, ?,?, ?, ?, ?)";
	        
	        // Execute the INSERT query using JdbcTemplate
	        int rowsAffected = jdbcTemplate.update(sql, parseInt,doctorId, name, gender, phone, age);
	        
	        // Check if the insertion was successful (1 row affected
	        if(rowsAffected >0)
	        	return true;
	        
	        return false;
	    
	}


}