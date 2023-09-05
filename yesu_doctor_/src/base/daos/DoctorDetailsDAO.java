package base.daos;

import java.util.List;
import java.util.Map;

import base.models.AppointmentSchedule;
import base.models.Doctor;

public interface DoctorDetailsDAO {
	public List<Doctor> getAllDoctorsInfo();

	public Doctor getDoctorInfoById(int id);

	public List<AppointmentSchedule> getAppointmentScheduleById(int docid);

	public List<Doctor> getAllDoctorsBySpecialization(String specialization);

	public List<Map<String, Object>> getAllSpecializations();

	public boolean updateStatus(String selectedSlot);

	public List<Doctor> doctorDetails(int parseInt);

	public List<AppointmentSchedule> timeSlots(int parseInt);
	public boolean patientDetails_dals(int doctor_id,int parseInt, String name, String gender, String phone, int age);
	
}
