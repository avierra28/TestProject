package com.tony.application.bomedical;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.tony.application.models.Patient;

@Component
public class MedicalValidations {
	
	public String errorChecking(Patient patient) {
		
		String regexString = "^\\d{4}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$", errorString = "";
		
		errorString = errorCheck1(patient, regexString, errorString);
		
		return errorString;
	}

	public String errorCheck1(Patient patient, String regexString, String errorString) {
		if(patient.getFirstName().equals("")) {
			errorString += "Please specify first name <br />";
		}
		if(patient.getLastName().equals(""))
			errorString += "Please specify last name <br/ >";
		if(patient.getAge() <= 0) {
			errorString += "Please specifiy age <br />";
		}
		if(patient.getDateOfBirth() == null) {
			errorString += "Invalid date. <br />";
		}
		if(patient.getCondition().equals("")) {
			errorString += "Please specify condition <br />";
		}
		if(patient.getSeriousnes() < 1 || patient.getSeriousnes() > 10) {
			errorString += "Invalid seriousness <br />";
		}
		return errorString;
	}
}
