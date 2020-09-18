package com.tony.application.controllershome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.application.bohome.BusinessLogic;
import com.tony.application.bomedical.SessionStaffMember;
import com.tony.application.models.MedicalStaff;

@Controller
public class MedicalController {
	
	@Autowired
	private BusinessLogic myBO;
	
	@Autowired
	private static MedicalStaff medicalStaff;

	@RequestMapping("/")
	public String indexController() {
		return "/webflow/mainhome";
	}
	
	@RequestMapping("/medicalone")
	public String medical1() {
		return "/webflow/login";
	}
	
	@RequestMapping("/medicaltwo")
	public String medical2(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, Model model) {
		
		List<MedicalStaff> myList = myBO.staffSignIn(email, password);
		
		if(!myList.get(1).getComments().equals("")) {
			model.addAttribute("errorMessage", myList.get(1).getComments());
			return "/webflow/login";
		}
		else {
			medicalStaff = myList.get(0);
			SessionStaffMember.setSessionStaff(myList.get(0));
			model.addAttribute("staffMember", medicalStaff);
			return "/";
		}
		
	}
	
	@RequestMapping("/medicalthree")
	public String medical3(@ModelAttribute MedicalStaff medicalStaff) {
		return "/webflow/medicalregister";
	}
	
	@RequestMapping("/medicalfour")
	public String medical4(MedicalStaff med, Model model) {
		
		// Try to add the new record.
		String errorString = myBO.addStaff(med);
		
		if(errorString.equals("")) {
			model.addAttribute("suc", "Creation Sucess");
			return "home";
		}
		else {
			model.addAttribute("errorMessage", errorString);
			return "CreateMedical";
		}
	}
	
	@RequestMapping("/medical")
	public String homeDirected(Model model) {
		
		model.addAttribute("staffMember", medicalStaff);
		
		return "/medical/MedicalHome";
	}
	
	@RequestMapping("/aboutus")
	public String aboutUs() {
		return "/webflow/aboutus";
	}
	
	@RequestMapping("/ourstaff")
	public String ourStaff(Model model) {
		return "/webflow/staff";
	}

	public static MedicalStaff getMedicalStaff() {
		return medicalStaff;
	}

	public static void setMedicalStaff(MedicalStaff medicalStaff) {
		MedicalController.medicalStaff = medicalStaff;
	}
	
}














