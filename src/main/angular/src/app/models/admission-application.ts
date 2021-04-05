import { CourseByInTake } from './course-by-in-take';
import { GenericFields } from './generic-fields';;
import { User } from './user';

export declare type AdmissionApplicationStatus = "SUBMITTED" | "UNDER_VERIFICATION" | "DECISION_PENDING" | "APPROVED" | "REJECTED" | "WITHDREW";

export interface AdmissionApplication extends GenericFields {
    user ?: User;
    courseByInTake ?: CourseByInTake;
    notes ?: string;
    status ?: AdmissionApplicationStatus
}
