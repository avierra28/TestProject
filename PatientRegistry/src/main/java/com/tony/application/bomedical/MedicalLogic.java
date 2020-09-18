package com.tony.application.bomedical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.application.dao.DAOMedical;
import com.tony.application.dao.DAOPatients;
import com.tony.application.models.MedicalStaff;
import com.tony.application.models.Patient;

@Service
public class MedicalLogic {

	@Autowired
	private MedicalValidations validations;
	@Autowired
	private DAOPatients dao;
	@Autowired
	private DAOMedical daoMedical;

	public String addPatient(Patient patient) {

		String errString = "";

		errString = validations.errorChecking(patient);

		if (errString.equals("")) {
			dao.addPatient(patient);
		}

		return errString;
	}

	public String updatePatient(Patient patient) {

		String errString = "";

		errString = validations.errorChecking(patient);

		if (errString.equals("")) {
			dao.updatePatient(patient);
		}

		return errString;
	}
	
	public List<Patient> getPatients() {
		return dao.getAllPatients();
	}
	
	public Patient getUniquePatient(int id) {
		return dao.retrieveUniquePatient(id);
	}
	
	public List<Patient> getSorted(String query) {
		return dao.getSortedPatients(query);
	}
	
	public void updateMedical(MedicalStaff medicalStaff) {
		
		daoMedical.updateMedical(medicalStaff);
	}
	
	public MedicalStaff retrieveStaff(int id) {
		return daoMedical.retrieveStaffMember(id);
	}
}


















