package com.tony.application.dao;

import java.util.List;

import com.tony.application.models.Patient;

public interface PatientDataBase {

	void addPatient(Patient patient);

	List<Patient> getAllPatients();

	List<Patient> getSortedPatients(String query);

	Patient retrieveUniquePatient(int id);

	void updatePatient(Patient patient);

	void deletePatient(Patient patient);

}