import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CurrentUser } from 'src/app/models/user-role';
import { ApiService } from '../apis/api.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private apiVersion :string;
  private currentUser : CurrentUser = null;
  private currentUseSubject = new BehaviorSubject<CurrentUser>(null);
  private isCurrentUserLoading = false;
  
  constructor(private http:HttpClient,
              private apiService:ApiService) { 
              this.apiVersion = this.apiService.getApiVersion();
  }

  private getCurrentUserApi(){
    return this.http.get(this.apiVersion+"/userrole/current",{observe:"response"});
  }

  private fetchCurrentUser(){
    this.isCurrentUserLoading = true;

    this.getCurrentUserApi().subscribe(resp =>{
      this.isCurrentUserLoading = false;
        if(resp.ok && resp.body != null){
            this.currentUser = resp.body as CurrentUser;
            this.currentUseSubject.next(this.currentUser)
        }else{
            this.currentUser = {isError:true};
            this.currentUseSubject.next(this.currentUser);          
        }
    },err =>{
      this.currentUser = {isError:true};
      this.currentUseSubject.next(this.currentUser);
    })
  }

  public getCurrentUser_async(from?:string){
    if((this.currentUser == null &&  this.isCurrentUserLoading == false))
    {
      this.fetchCurrentUser();
    }

    return this.currentUseSubject;
  }

  public isCurrentRoleAdminReleatedRole(){
    if(this.isCurrentUserLoading || this.currentUser == null || this.currentUser.isError)
      return false;
    else{
        let roleName = this.currentUser.role.name;
      if(["ROLE_Super_User","ROLE_Principal","ROLE_Management"].includes(roleName))
           return true;
        else 
           return false;
    }

  }

}
