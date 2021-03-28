package com.msd.portal.enumtypes;

/**
 * 
 * @author sudheer mende
 *
 */

public enum ApplicationStatus {
	SUBMITTED, // 1 submitted by applicant 
	UNDER_VERIFICATION, // 2 received application and status changed
	DECISION_PENDING, // 3 Decision Pending
	APPROVED,// 4 Approved 
	REJECTED,// 4 Rejected
	WITHDREW // Applicant can cancel
}
