package com.tony.application.medicalcontrollers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.application.bomedical.MedicalLogic;
import com.tony.application.dao.DAOMedical;
import com.tony.application.dao.DAOPatients;
import com.tony.application.models.Patient;

@Controller
public class MedicalStaffView implements MedicalView {

	@Autowired
	private MedicalLogic businessService;

	@Override
	@RequestMapping("/medical/patientView")
	public String loadPage(Model model) {

		List<Patient> myPatients = businessService.getPatients();

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort1")
	public String sortingPage1(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by patient_id asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort2")
	public String sortingPage2(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by patient_id desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort3")
	public String sortingPage3(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by first_name asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort4")
	public String sortingPage4(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by first_name desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort5")
	public String sortingPage5(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by last_name asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort6")
	public String sortingPage6(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by last_name desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort7")
	public String sortingPage7(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by age asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort8")
	public String sortingPage8(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by age desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort9")
	public String sortingPage9(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by date_of_birth asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort10")
	public String sortingPage10(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by date_of_birth desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort11")
	public String sortingPage11(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by their_condition asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort12")
	public String sortingPage12(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by their_condition desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort13")
	public String sortingPage13(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by seriousness asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort14")
	public String sortingPage14(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by seriousness desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort15")
	public String sortingPage15(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by room_number asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort16")
	public String sortingPage16(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by room_number desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort17")
	public String sortingPage17(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by added_by asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort18")
	public String sortingPage18(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by added_by desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@Override
	@RequestMapping("/medical/patientSort19")
	public String sortingPage19(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by comments asc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}

	@Override
	@RequestMapping("/medical/patientSort20")
	public String sortingPage20(Model model) {

		List<Patient> myPatients = businessService.getSorted("from Patient order by comments desc");

		model.addAttribute("myPatients", myPatients);

		return "/medical/medicalviewpatients";
	}
	
	@RequestMapping("/medical/viewDelete")
	public String deleteButton(@RequestParam("identification") int id) {
		
		DAOPatients daoPatients = new DAOPatients();
		Patient patient = new Patient();
		patient = daoPatients.retrieveUniquePatient(id);
		
		daoPatients.deletePatient(patient);
		
		return "/medical/medicalviewpatients";
	}
	
	@RequestMapping("/medical/viewEdit")
	public String viewEdit(@ModelAttribute("patientperson") Patient patient, Model model, @RequestParam("identification") int id) {
		
		DAOPatients daoPatients = new DAOPatients();
		Patient patient2 = new Patient();
		patient2 = daoPatients.retrieveUniquePatient(id);
		
		List<Patient> myPatients = businessService.getPatients();

		model.addAttribute("myPatients", myPatients);
		
		model.addAttribute("uniquePatient", patient2);
		
		
		return "/medical/medicalviewpatients"; 
	}
	
	@RequestMapping("/medical/finalUpdatePatient")
	public String viewEdit2(Patient patient) {
		
		
		
		return "/medical/medicalviewpatients";
	}
}


















