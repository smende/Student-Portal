package com.msd.portal.util;

import java.util.ArrayList;
import java.util.List;

import com.msd.portal.enumtypes.ApplicationStatus;

public class CommonUtil {

	public static List<ApplicationStatus> getAdmissionApplicationPositiveStatusList(){
		List<ApplicationStatus> listOfStatus = new ArrayList<>();
		listOfStatus.add(ApplicationStatus.SUBMITTED);
		listOfStatus.add(ApplicationStatus.UNDER_VERIFICATION);
		listOfStatus.add(ApplicationStatus.DECISION_PENDING);
		listOfStatus.add(ApplicationStatus.APPROVED);
		
		return listOfStatus;
	}
	
	public static List<ApplicationStatus> getAdmissionApplicationNegativeStatusList(){
		List<ApplicationStatus> listOfStatus = new ArrayList<>();
		listOfStatus.add(ApplicationStatus.WITHDREW);
		listOfStatus.add(ApplicationStatus.DENIED);
		return listOfStatus;
	}
	
	public static List<ApplicationStatus> getAllApplicationStatus(){
		List<ApplicationStatus> listOfStatus = new ArrayList<>();
		listOfStatus.add(ApplicationStatus.SUBMITTED);
		listOfStatus.add(ApplicationStatus.UNDER_VERIFICATION);
		listOfStatus.add(ApplicationStatus.DECISION_PENDING);
		listOfStatus.add(ApplicationStatus.APPROVED);
		listOfStatus.add(ApplicationStatus.WITHDREW);
		listOfStatus.add(ApplicationStatus.DENIED);
		return listOfStatus;
	}
}
