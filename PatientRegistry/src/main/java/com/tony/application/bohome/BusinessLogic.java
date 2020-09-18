package com.tony.application.bohome;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.application.dao.DAOMedical;
import com.tony.application.models.MedicalStaff;
import com.tony.application.models.Patient;

@Service
public class BusinessLogic {

	@Autowired
	private DAOMedical myDao;
	@Autowired
	private Validations validations;
	@Autowired
	private MedicalStaff medicalStaff;
	
	public List<MedicalStaff> staffSignIn(String email, String password) {
		
		String errorString = "";
		List<MedicalStaff> myList = new ArrayList<MedicalStaff>();
		MedicalStaff medical = new MedicalStaff();
		
		medicalStaff = myDao.retrieveUniqueMedical(email, password);
		
		myList.add(medicalStaff);
		
		if(medicalStaff == null) {
			errorString += "That entry does not exist <br />";
			
			medical.setComments(errorString);
			myList.add(medical);
		} else {
			medical.setComments("");
			myList.add(medical);
		}
		
		return myList;
		
	}
	
	
	public String addStaff(MedicalStaff medicalStaff) {
		 String errorString = "";
		 
		 errorString = validations.checkEntryStaff(medicalStaff);
		 
		 if(errorString.equals("")) {
			 myDao.addMedical(medicalStaff);
		 }
		 
		 return errorString;
	}
}
