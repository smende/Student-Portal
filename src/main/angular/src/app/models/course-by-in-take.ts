import { Course } from './course';
import { GenericFields } from './generic-fields';
import { InTake } from './in-take';

export interface CourseByInTake extends GenericFields{
    course ?: Course;
    inTake ?: InTake;
}

export interface CourseByInTakeListByInTake{
    inTake ?: InTake;
    courseByInTakeList ?: CourseByInTake[];
}