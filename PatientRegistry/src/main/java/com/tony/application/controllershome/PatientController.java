package com.tony.application.controllershome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

	@RequestMapping("/patientone")
	public String mainPatient() {
		return "patientSignIn";
	}
	
	public String mainPatient2(@RequestParam("email") String email, @RequestParam("password") String pass) {
		return "";
	}
}
