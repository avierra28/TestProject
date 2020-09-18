package com.tony.application.medicalcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.application.dao.DAOMedical;
import com.tony.application.dao.DAOPatients;
import com.tony.application.models.Patient;

@Controller
public class MedicalStaffDelete {
	
	@Autowired
	private DAOPatients dao;
	private static int idNum;

	@RequestMapping("/medical/deletePatient")
	public String deletePatient(Model model) {
		
		List<Patient> myPatients = dao.getAllPatients();
		model.addAttribute("myPatients", myPatients);
		
		return "/medical/medicaldeletepatient";
	}
	
	@RequestMapping("/medical/patientDelete2")
	public String deletePatient2(@RequestParam("idNumber") int id, Model model) {
		
		idNum = id;
		Patient patient = new Patient();
		List<Patient> myPatients = dao.getAllPatients();
		model.addAttribute("myPatients", myPatients);
		patient = dao.retrieveUniquePatient(id);
		model.addAttribute("uniquePatient", patient);
		
		return "/medical/medicaldeletepatient";
	}
	
	@RequestMapping("/medical/finalDelete")
	public String deletePatient3(Model model) {
		
		dao.deletePatient(dao.retrieveUniquePatient(idNum));
		List<Patient> myPatients = dao.getAllPatients();
		model.addAttribute("myPatients", myPatients);
		
		return "/medical/medicaldeletepatient";
	}
}


















