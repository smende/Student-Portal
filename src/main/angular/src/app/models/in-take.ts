import { GenericFields } from './generic-fields';

export interface InTake extends GenericFields{
    name ?: string;
	startDate ?: Date;
	endDate ?: Date;
	details ?: string;
}