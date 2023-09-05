

package base.controllers;

import base.services.DoctorDetailsService;
import base.daos.DoctorDetailsDAO;
import base.models.AppointmentSchedule;
import base.models.Doctor;
import base.models.User;
import base.models.UserCred;
import base.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BaseController {
    private final DoctorDetailsService doctorDetailsService;
    List<AppointmentSchedule> s;
	boolean b;
	String slotid;

	UserDAO userdal;
	DoctorDetailsDAO doctorddal;

	@Autowired
	public BaseController(UserDAO u, DoctorDetailsService doctorDetailsService) {
		userdal = u;
		
        this.doctorDetailsService = doctorDetailsService;

	}


   
    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    public String home(UserCred userCred, Model model) {
        String password = userCred.getPassword();
        User user = userdal.getUserById(userCred.getUsername());
        if (password.equals(user.getuPass())) {
            model.addAttribute("doctorsData", doctorDetailsService.getAllDoctorsInfo());
            model.addAttribute("specializationData", doctorDetailsService.getAllSpecializations());
            return "DoctorList";
        } else {
            return "wrongCred";
        }
    }

    @RequestMapping(value = "/doctorList", method = RequestMethod.GET)
    public String doctorList(@RequestParam("specialization") String specialization, Model model) {
        model.addAttribute("specializationData", doctorDetailsService.getAllSpecializations());
        model.addAttribute("doctorsData", doctorDetailsService.getAllDoctorsBySpecialization(specialization));
        return "DoctorList";
    }

    @RequestMapping(value = "/doctorDetails", method = RequestMethod.GET)
    public String doctorDetails(@RequestParam("doctorid") int doctorid, Model model) {
        model.addAttribute("doctor", doctorDetailsService.getDoctorInfoById(doctorid));
        return "DoctorDetails";
    }

    @RequestMapping(value = "/doctorCalendar", method = RequestMethod.GET)
    public String doctorCalendar(@RequestParam("doctorid") int doctorid, Model model) {
        model.addAttribute("doctorSchedule", doctorDetailsService.getAppointmentScheduleById(doctorid));
        System.out.println(doctorDetailsService.getAppointmentScheduleById(doctorid).get(0).getSlotfrom());
        System.out.println(doctorid);
        return "DoctorCalendar";
    }

    @RequestMapping(value = "/getDoctorSchedule", method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentSchedule> doctorSchedule(@RequestParam("doctorid") int doctorid, Model model) {
        return doctorDetailsService.getAppointmentScheduleById(doctorid);
    }

    @RequestMapping(value = "/SlotsUpdated", method = RequestMethod.POST)
    public String handleBooking(
            @RequestParam("doctorId") String doctorId,
            @RequestParam("selectedDate") String selectedSlot) {
        slotid = selectedSlot;
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Selected slot id : " + selectedSlot);
        s = doctorDetailsService.timeSlots(Integer.parseInt(selectedSlot));
        // Redirect to a confirmation page or any other appropriate page.
        return "patientDetails"; // This should match the name of your HTML template.
    }

    @RequestMapping(value = "/BookingDetails", method = RequestMethod.POST)
    public String Booking(
            @RequestParam("doctorId") String doctorId,
            @RequestParam("selectedSlot") String selectedSlot,
            @RequestParam("patientId") String patientId,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("phone") String phone,
            @RequestParam("age") int age, Model model) {
        // Now you have access to all patient details
        b = doctorDetailsService.updateStatus(slotid);
       
        // Get doctor details and add them to the model
        List<Doctor> doctorDetails = doctorDetailsService.doctorDetails(Integer.parseInt(doctorId));
        model.addAttribute("doctor", doctorDetails);
        System.out.println(s.get(0).getSlotfrom());
        
        boolean check=doctorDetailsService.PatientDetails_service(Integer.parseInt(doctorId),Integer.parseInt(patientId),name,gender,phone,age);
        // Add patient details to the model
        model.addAttribute("patientId", patientId);
        model.addAttribute("selectedSlot", selectedSlot);
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("phone", phone);
        model.addAttribute("age", age);
        model.addAttribute("SlotTimeFrom", s.get(0).getSlotfrom());
        model.addAttribute("SlotTimeTo", s.get(0).getSlotto());
        model.addAttribute("SlotTimeDate", s.get(0).getSlotdate());
        // Redirect to a confirmation page or any other appropriate page.
        return "Booking"; // This should match the name of your HTML template.
    }
}





