import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';
import { MenuItem } from 'src/app/models/menu-item';
import { CurrentUser } from '../../../models/user-role';
import { CurrentUserService } from '../../../services/currentUser/current-user.service';
import { CommonViewService } from '../../services/common-view.service';

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
  
  menu : MenuItem[] = [];

  constructor(private currentUserService:CurrentUserService,
              private commonViewService : CommonViewService) {

              }

  ngOnInit(): void {
    this.isLoading = true;
    this.currentUserService.getCurrentUser_async("topNav").subscribe(currentUser =>{
      if(currentUser == null)
          return;
            
      this.currentUser = currentUser;
      if(!currentUser.isError){
        this.menu = this.commonViewService.getMenuOptionsByUserRole(currentUser.role.name);
        this.isLoading = false;
      }
    })

  }

  toggleSideNav(mode:"over"|"side"){
    this.modeChange.emit(mode);
    this.drawer.toggle();
  }

}
