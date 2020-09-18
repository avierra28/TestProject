package com.tony.application.medicalcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.application.bomedical.MedicalLogic;
import com.tony.application.models.Patient;

@Controller
public class MedicalStaffAdd {
	
	@Autowired
	private MedicalLogic businessLogic;
	
	@RequestMapping("/medical/patientAdd")
	public String addPatient(@ModelAttribute Patient patient) {
		return "/medical/medicaladdpatient";
	}
	
	@RequestMapping("/medical/processPatient")
	public String processPatient(Patient patient, Model model) {
		
		// Send it to the service.  
		
		String errorString = businessLogic.addPatient(patient);
		
		if(errorString.equals("")) {
			
			model.addAttribute("success", "Patient added successfully. Click view above to see patient.");
			return "/medical/MedicalHome";
		}
		else {
			model.addAttribute("errorMessage", errorString);
			return "/medical/medicaladdpatient";
		}
	}
	
}
