package com.tony.application.medicalcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.application.bomedical.SessionStaffMember;

@Controller
public class MedicalStaffProfileView {

	@RequestMapping("/medical/medicalProfileView")
	public String viewProfile(Model model) {
		
		model.addAttribute("staff", SessionStaffMember.getSessionStaff());
		
		return "/medical/medicalprofileview";
	}
}
