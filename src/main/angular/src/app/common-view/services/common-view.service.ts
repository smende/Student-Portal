import { Injectable } from '@angular/core';
import { MenuItem } from '../../models/menu-item';

@Injectable()
export class CommonViewService {

  private applicantMenu : MenuItem[] =[
    {label:"Admissions",url:"admissions"},
    {label:"My Applications",url:"applications"}    
  ]
  private superUserMenu : MenuItem[] =[
    {label:"Admissions",url:"admissions"},
    {label:"Applications",url:"applications"}    
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
