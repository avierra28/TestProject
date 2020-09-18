package com.tony.application.bohome;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.tony.application.models.MedicalStaff;

@Service
public class Validations {
	
	public String checkEntryStaff(MedicalStaff med) {
		
		String errorString = getErrorString1(med, "");
		
		return errorString;
	}

	public String getErrorString1(MedicalStaff med, String errorString) {
		String regex = "[a-zA-Z0-9 _\\-]*";
		
		if(med.getFirstName().equals("")) {
			errorString += "First name cannot be empty. <br />";
		}
		if(med.getLastName().equals("")) {
			errorString += "Last name cannot be empty. <br />";
		}
		if(med.getPosition().equals("")) {
			errorString += "Position cannot be empty. <br />";
		}
		if(med.getYearsExp() <= 0) {
			errorString += "Years of experience cannot be empty. <br />";
		}
		if(med.getEmailId().equals("")) {
			errorString += "Email Id cannot be empty. <br />";
		}
		if(med.getPassword().equals("")) {
			errorString += "Password cannot be empty. <br />";
		}
		
		if(!Pattern.matches(regex, med.getPassword())) {
			errorString += "City can contain only letters, numbers, and Spaces, Hyphens (-), underscores (_). Please enter a valid City. <br />";
		}
		
		
		return errorString;
	}
}
