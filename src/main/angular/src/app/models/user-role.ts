import { GenericFields } from './generic-fields';
import { Role } from './role';
import { User } from './user';

export interface UserRole extends GenericFields{
    user ?: User;
    role ?: Role;
    currentRole ?: boolean;

    isError ?: boolean;
}

export declare type CurrentUser = UserRole;