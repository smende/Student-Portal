package com.msd.portal.enumtypes;

/**
 * 
 * @author sudheer mende
 *
 */

public enum ApplicationStatus {
	SUBMITTED, // submitted by applicant 
	UNDER_VERIFICATION, // received application and status changed
	DECISION_PENDING, // Decision Pending
	APPROVED,// Approved 
	DENIED,// Rejected
	WITHDREW // Applicant cancelled application
}
