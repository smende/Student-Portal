import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from 'src/app/models/user';
import { ApiService } from '../apis/api.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private apiVersion :string;
  private currentUser : User = null;
  private currentUseSubject = new BehaviorSubject<User>(null);
  private isCurrentUserLoading = false;
  
  constructor(private http:HttpClient,
              private apiService:ApiService) { 
              this.apiVersion = this.apiService.getApiVersion();
  }

  private getCurrentUserApi(){
    return this.http.get(this.apiVersion+"/user/current",{observe:"response"});
  }

  private fetchCurrentUser(){
    this.isCurrentUserLoading = true;

    this.getCurrentUserApi().subscribe(resp =>{
      this.isCurrentUserLoading = false;
        if(resp.ok && resp.body != null){
            this.currentUser = resp.body as User;
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

  public getCurrentUser_async(){
    if((this.currentUser == null &&  this.isCurrentUserLoading == false) || (this.currentUser != null && this.currentUser.isError == true))
    {
      this.fetchCurrentUser();
    }

    return this.currentUseSubject;
  }


}
