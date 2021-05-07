import { GenericFields } from './generic-fields';
import { Role } from './role';
import { User } from './user';

export interface UserRole extends GenericFields{
    user ?: User;
    role ?: Role;
    currentRole ?: boolean;
}

export interface CurrentUser extends UserRole{
    isError ?: boolean;
    env ?: string;
}