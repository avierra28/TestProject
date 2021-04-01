package com.tony.bo;

import java.util.regex.Pattern;

/*
 * Wondering what this is.
 */

import org.springframework.stereotype.Component;

@Component
public class ValidationsImp implements Validations {
	
	
	public String secondCheck(String errorMessage, String regex1, String fNameString, String lNameString,
			String mNameString) {
		if (!isBlank(mNameString)) {

			if (contentCheck(mNameString, regex1))
				errorMessage += "Middle Name can contain only letters, numbers, and Spaces, Hyphens (-), underscores (_). Please enter a valid Middle Name. <br />";
		}

		if (!isBlank(fNameString)) {
			if (!firstCharacterCheck(fNameString))
				errorMessage += "First Name must start with a letter. <br />";

			if (contentCheck(fNameString, regex1) && !nameLength(fNameString))
				errorMessage += "First name can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid First Name. <br />";

		}

		if (!isBlank(lNameString)) {
			if (!firstCharacterCheck(lNameString))
				errorMessage += "Last Name must start with a letter. <br />";

			if (contentCheck(lNameString, regex1))
				errorMessage += "Last name can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid Last Name. <br />";

		}
		return errorMessage;
	}
	
	public String firstCheck(String errorMessage, String fNameString, String lNameString) {
		if (isBlank(fNameString)) {
			errorMessage += "Please specify First Name <br />";
		}
		if (isBlank(lNameString)) {
			errorMessage += "Please specify Last Name <br />";
		}
		if (nameLength(fNameString) && !isBlank(fNameString))
			errorMessage += "The First Name is less than 2 characters. Please check and enter a valid First Name <br />";
		if (nameLength(lNameString) && !isBlank(lNameString))
			errorMessage += "The Last Name is less than 2 characters. Please check and enter a valid Last Name <br />";

		return errorMessage;
	}

	public boolean contentCheck(String mNameString, String regex) {
		return !Pattern.matches(regex, mNameString);
	}

	public boolean firstCharacterCheck(String fNameString) {
		String regexString = "[a-zA-Z0-9 _\\-]";
		return Pattern.matches(regexString, String.valueOf(fNameString.charAt(0)));

	}

	public boolean nameLength(String fNameString) {
		return fNameString.length() < 2;
	}

	public boolean isBlank(String fNameString) {
		return fNameString.equals("");
	}
	
	public String fifthCheck(String errorString, String regex, String stateString, String countryString,
			String phoneString) {
		if (stateString.equals("invalid"))
			errorString += "State is required. Please select one from the list. <br/>";
		if (countryString.equals("invalid"))
			errorString += "Country is required. Please select one from the list. <br />";
		if (phoneLength(phoneString))
			errorString += "Phone number must contains 10 digits. Please enter a valid Phone number. <br />";

		if (contentCheck(phoneString, regex))
			errorString += "Invalid phone number digits enter again. <br />";
		return errorString;
	}

	public String fourthCheck(String errorString, String addressString, String cityString) {
		if (isBlank(addressString))
			errorString += "Please specify Address. <br />";
		if (isBlank(cityString))
			errorString += "Please specify City. <br/>";
		if (!isBlank(cityString)) {
			String regex = "[a-zA-Z0-9 _\\-]*";
			if (contentCheck(cityString, regex))
				errorString += "City can contain only letters, numbers, and Spaces, Hyphens (-), underscores (_). Please enter a valid City. <br />";
		}
		return errorString;
	}
	
	public boolean phoneLength(String phoneString) {
		return phoneString.length() != 10;
	}

}
