package base.services;

import base.models.AppointmentSchedule;
import base.models.Doctor;

import java.util.List;
import java.util.Map;
import base.dals.DoctorDetailsDAL;
import base.models.AppointmentSchedule;
import base.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface DoctorDetailsService {
    List<Doctor> getAllDoctorsInfo();

    List<Doctor> getAllDoctorsBySpecialization(String specialization);

    Doctor getDoctorInfoById(int docId);

    List<AppointmentSchedule> getAppointmentScheduleById(int docId);

    List<Map<String, Object>> getAllSpecializations();

    boolean updateStatus(String selectedSlot);

    List<Doctor> doctorDetails(int id);

    List<AppointmentSchedule> timeSlots(int id);

	boolean PatientDetails_service(int parseInt, int i, String name, String gender, String phone, int age);
}






@Service
 class DoctorDetailsServiceImpl implements DoctorDetailsService {

    private final DoctorDetailsDAL doctorDetailsDAL;

    @Autowired
    public DoctorDetailsServiceImpl(DoctorDetailsDAL doctorDetailsDAL) {
        this.doctorDetailsDAL = doctorDetailsDAL;
    }

    @Override
    public List<Doctor> getAllDoctorsInfo() {
        return doctorDetailsDAL.getAllDoctorsInfo();
    }

    @Override
    public List<Doctor> getAllDoctorsBySpecialization(String specialization) {
        return doctorDetailsDAL.getAllDoctorsBySpecialization(specialization);
    }

    @Override
    public Doctor getDoctorInfoById(int docId) {
        return doctorDetailsDAL.getDoctorInfoById(docId);
    }

    @Override
    public List<AppointmentSchedule> getAppointmentScheduleById(int docId) {
        return doctorDetailsDAL.getAppointmentScheduleById(docId);
    }

    @Override
    public List<Map<String, Object>> getAllSpecializations() {
        return doctorDetailsDAL.getAllSpecializations();
    }

    @Override
    public boolean updateStatus(String selectedSlot) {
        return doctorDetailsDAL.updateStatus(selectedSlot);
    }

    @Override
    public List<Doctor> doctorDetails(int id) {
        return doctorDetailsDAL.doctorDetails(id);
    }

    @Override
    public List<AppointmentSchedule> timeSlots(int id) {
        return doctorDetailsDAL.timeSlots(id);
    }

	@Override
	public boolean  PatientDetails_service(int doctor_id,int parseInt, String name, String gender, String phone, int age) {
		
		return doctorDetailsDAL.patientDetails_dals(doctor_id,parseInt,name,gender,phone,age);
	}
}




