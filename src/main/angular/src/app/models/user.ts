import { GenericFields } from './generic-fields';


export interface User extends GenericFields{
    userName ?: string;
    firstName ?: string;
    lastName ?: string;
    email ?: string;
    cell ?: string;
}