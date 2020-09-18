package com.tony.application.dao;

import com.tony.application.models.MedicalStaff;

public interface MedicalDataBase {

	void addMedical(MedicalStaff medicalStaff);

	void updateMedical(MedicalStaff medicalStaff);

	MedicalStaff retrieveStaffMember(int id);

	MedicalStaff retrieveUniqueMedical(String email, String password);

	void deleteMedical(MedicalStaff medicalStaff);

}