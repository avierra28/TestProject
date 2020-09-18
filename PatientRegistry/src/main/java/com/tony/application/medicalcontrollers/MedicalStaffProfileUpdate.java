package com.tony.application.medicalcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.application.bomedical.MedicalLogic;
import com.tony.application.bomedical.SessionStaffMember;
import com.tony.application.controllershome.MedicalController;
import com.tony.application.dao.DAOMedical;
import com.tony.application.models.MedicalStaff;

@Controller
public class MedicalStaffProfileUpdate {
	
	@Autowired
	private MedicalLogic businessMedical;

	@RequestMapping("/medical/medicalProfile")
	public String forwardToPage(@ModelAttribute MedicalStaff medicalStaff, Model model) {
		
		SessionStaffMember.setSessionStaff(businessMedical.retrieveStaff(SessionStaffMember.getSessionStaff().getId()));
		model.addAttribute("bio", SessionStaffMember.getSessionStaff().getBiography());
		model.addAttribute("staff", SessionStaffMember.getSessionStaff());
		
		return "/medical/medicalprofileupdate";
	}
	
	@RequestMapping("/medical/processMedical")
	public String updateMedical(MedicalStaff medical, Model model) {
		
		medical.setId(SessionStaffMember.getSessionStaff().getId());
		
		businessMedical.updateMedical(medical);
		
		model.addAttribute("staffMember", SessionStaffMember.getSessionStaff());
		
		return "/medical/MedicalHome";
	}
}
