import { Route } from '@angular/router';

export interface CustomData {
    title ?: string;
    pageName ?: string;
    module ?: string;
    pageType ?: string;
    standAlone ?: boolean; // doesn't need options menu, just plain page
    staticModule ?: boolean; // doesn't need user details
    permissions ?: string[];
    roles ?: string[];
    pageNameForPermissions ?: string;
    redirectUrl ?: string; 
}

interface CustomRoute extends Route{
    data ?: CustomData;
    children ?: CustomRoute[]
}

export declare type CustomRoutes = CustomRoute[];