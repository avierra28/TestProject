package com.tony.application.testcase;

import java.util.Date;

import com.tony.application.dao.DAOMedical;
import com.tony.application.models.MedicalStaff;
import com.tony.application.models.Patient;

public class Test1 {

	public static void main(String[] args) {

//		MedicalStaff medicalStaff = new MedicalStaff(1, "Steve", "Jimmy", "Nurse", 4, "very good nurse!", "steveJimmy@gmail.com", "hello");
		DAOMedical dao = new DAOMedical();
//		
//		dao.addMedical(medicalStaff);
		
		Date todaysDate = new Date();
		
		Patient patient = new Patient(1, "Joe", "lee", 45, todaysDate, "His condition is he needs his appendix taken out in surgery", "This man came in presented with...", 4, 206);
		
		
	}

}
