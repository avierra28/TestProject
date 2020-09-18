package com.tony.application.medicalcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.application.bomedical.MedicalLogic;
import com.tony.application.bomedical.MedicalValidations;
import com.tony.application.dao.DAOMedical;
import com.tony.application.dao.DAOPatients;
import com.tony.application.models.Patient;

@Controller
public class MedicalStaffUpdate {
	
	private int idNum;
	
	@Autowired
	private MedicalLogic businessService;

	@RequestMapping("/medical/patientUpdate")
	public String staffUpdate(Model model) {
		List<Patient> myPatients = businessService.getPatients();
		model.addAttribute("myPatients", myPatients);
		return "/medical/medicalupdatepatient";
	}
	
	@RequestMapping("/medical/patientUpdate2")
	public String getSinglePatient(@RequestParam("idNumber") int id, Model model, @ModelAttribute Patient patient) {
		
		idNum = id;
		List<Patient> myPatients = businessService.getPatients();
		model.addAttribute("myPatients", myPatients);
		model.addAttribute("uniquePatient", businessService.getUniquePatient(id));
		
		return "/medical/medicalupdatepatient";
	}
	
	@RequestMapping("/medical/finalUpdate")
	public String finalUpdate(Patient patient, Model model) {
		
		patient.setId(idNum);
		
		String errorString = businessService.updatePatient(patient);
		
		if(errorString.equals("")) {
			List<Patient> myPatients = businessService.getPatients();
			model.addAttribute("myPatients", myPatients);
			
			return "/medical/medicalupdatepatient";
		}
		else {
			List<Patient> myPatients = businessService.getPatients();
			model.addAttribute("myPatients", myPatients);
			model.addAttribute("errorMessage", errorString);
			model.addAttribute("uniquePatient", businessService.getUniquePatient(idNum));
			return "/medical/medicalupdatepatient";
		}
		
	}
	
}
