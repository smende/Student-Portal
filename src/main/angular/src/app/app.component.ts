import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { CustomData } from './models/custom-data';
import { User } from './models/user';
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
  currentUser:User;
  
  constructor(private currentUserService:CurrentUserService,
              private activetdRoute:ActivatedRoute,
              private utilService:UtilService,
              private titleService:Title){
                
    this.currentUserService.getCurrentUser_async().subscribe(user =>{
        if(user == null)
        return;
              
        this.currentUser = user;
    })
  }

  onRouteChange(){
    let finalChild = this.utilService.getFinalChildFromActivatedRoute(this.activetdRoute);
    let customData : CustomData = finalChild.data;

    let title = this.title +(customData.title != null ? " - "+customData.title : "");
    this.titleService.setTitle(title);
  }

}