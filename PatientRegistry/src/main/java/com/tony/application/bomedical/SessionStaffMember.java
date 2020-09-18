package com.tony.application.bomedical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.application.models.MedicalStaff;

@Service
public class SessionStaffMember {

	@Autowired
	private static MedicalStaff sessionStaff;

	public static MedicalStaff getSessionStaff() {
		return sessionStaff;
	}

	public static void setSessionStaff(MedicalStaff sessionStaff) {
		SessionStaffMember.sessionStaff = sessionStaff;
	}
	
	
}
