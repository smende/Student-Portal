import { Component, Input, OnInit } from '@angular/core';
import { CurrentUser } from 'src/app/models/user-role';
import { CommonViewService } from '../../services/common-view.service';
import { CurrentUserService } from '../../../services/currentUser/current-user.service';
import { MenuItem } from 'src/app/models/menu-item';
import { MatDrawer } from '@angular/material/sidenav';

@Component({
  selector: 'app-side-nav-bar',
  templateUrl: './side-nav-bar.component.html',
  styleUrls: ['./side-nav-bar.component.css']
})
export class SideNavBarComponent implements OnInit {

  menu : MenuItem[] = [];
  isLoading =  false;
  currentUser : CurrentUser;
  @Input() drawer : MatDrawer;
  @Input() mode : "over"|"side";

  constructor(private currentUserService:CurrentUserService,
              private commonViewService : CommonViewService) {

              }

  ngOnInit(): void {
    this.isLoading = true;
    this.currentUserService.getCurrentUser_async("sideNav").subscribe(currentUser =>{
      if(currentUser == null || currentUser.isError)
          return;
            
      this.currentUser = currentUser;
      this.menu = this.commonViewService.getMenuOptionsByUserRole(currentUser.role.name);
        this.isLoading = false;
    })

  }

  onClick(){
    if(this.mode == "over")
        this.drawer.toggle();
  }

}
