import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { CustomData } from './models/custom-data';
import { CurrentUser } from './models/user-role';
import { CurrentUserService } from './services/currentUser/current-user.service';
import { UtilService } from './services/util/util.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'MSD'
  schoolName = "Portal";
  currentUser:CurrentUser;
  isUserLoading = true;
  sideNavMode = "side";

  constructor(private currentUserService:CurrentUserService,
              private activetdRoute:ActivatedRoute,
              private utilService:UtilService,
              private titleService:Title){

    this.isUserLoading = true;          
    this.currentUserService.getCurrentUser_async("appcomp").subscribe(currentUser =>{
        if(currentUser == null)
        return;

        this.isUserLoading = false;
        this.currentUser = currentUser;
    })
  }

  onRouteChange(){
    let finalChild = this.utilService.getFinalChildFromActivatedRoute(this.activetdRoute);
    let customData : CustomData = finalChild.data;

    let title = this.title +(customData.title != null ? " - "+customData.title : "");
    this.titleService.setTitle(title);
  }

}