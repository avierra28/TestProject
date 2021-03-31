package com.tony.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Service
@Component
public class RecordBO extends Information implements Record {
	
	/*
	 * Pretty cool!
	 */

	/*
	 * This is a really big change!!!
	 */
	private Validations myValidations;

	@Autowired
	public RecordBO(Validations myValidations) {
		this.myValidations = myValidations;
	}

	public String addRecord(Bean entry) throws ClassNotFoundException, SQLException {

		String errorString = getErrorMessage(entry, "");

		if (errorString.length() == 0)
			restTemplate.postForLocation(addUrl, entry);
 
		return errorString;

	}

	public String getErrorMessage(Bean entry, String errorString) {
		errorString = myValidations.firstCheck(errorString, entry.getFirstName().trim(), entry.getLastName().trim());

		errorString = myValidations.secondCheck(errorString, "[a-zA-Z0-9 _\\-]*", entry.getFirstName().trim(),
				entry.getLastName().trim().trim(), entry.getMiddleName().trim());

		errorString = myValidations.fourthCheck(errorString, entry.getAddress(), entry.getCity());

		errorString = myValidations.fifthCheck(errorString, "[0-9]*", entry.getState(), entry.getCountry(),
				entry.getPhone());
		return errorString;
	}

}
