import { Injectable } from '@angular/core';
import { MenuItem } from '../../models/menu-item';

@Injectable()
export class CommonViewService {

  private applicantMenu : MenuItem[] =[
    {label:"Admissions",url:"admissions/all"},
    {label:"My Applications",url:"admissions/applications"}    
  ]
  private superUserMenu : MenuItem[] =[
    {label:"Admissions",url:"admissions/all"},
    {label:"Applications",url:"admissions/applications"}    
  ]

  private menu = {
    'ROLE_Applicant' : this.applicantMenu,
    'ROLE_Super_User': this.superUserMenu,    
  }
  
  constructor() { }

  getMenuOptions(){
    return this.menu;
  }

  getMenuOptionsByUserRole(roleName:string) : MenuItem[]{
    return (this.menu[roleName] == undefined ? this.menu['ROLE_Applicant'] : this.menu[roleName]);
  }
}
