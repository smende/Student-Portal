import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';
import { CurrentUser } from '../../../models/user-role';
import { CurrentUserService } from '../../../services/currentUser/current-user.service';

@Component({
  selector: 'app-top-nav-bar',
  templateUrl: './top-nav-bar.component.html',
  styleUrls: ['./top-nav-bar.component.css']
})
export class TopNavBarComponent implements OnInit {

  @Input() schoolName :string;
  @Input() drawer : MatDrawer;
  @Output() modeChange = new EventEmitter<'over'|'side'>()
  
  currentUser : CurrentUser;
  isLoading = false;
  
  applicantMenu =[
    {label:"Admissions",url:"admissions/all"},
    {label:"My Applications",url:"admissions/applications"}    
  ]
  superUserMenu =[
    {label:"Admissions",url:"admissions/all"},
    {label:"Applications",url:"admissions/applications"}    
  ]


  menu = {
    'ROLE_Applicant' : this.applicantMenu,
    'ROLE_Super_User': this.superUserMenu,    
  }


  constructor(private currentUserService:CurrentUserService) { }

  ngOnInit(): void {
    this.isLoading = true;
    this.currentUserService.getCurrentUser_async().subscribe(currentUser =>{
      if(currentUser == null)
          return;
            
      this.currentUser = currentUser;
        this.isLoading = false;
    })

  }

  toggleSideNav(mode:"over"|"side"){
    this.modeChange.emit(mode);
    this.drawer.toggle();
  }

}
