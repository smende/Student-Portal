import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/apis/api.service';
import { User } from 'src/app/models/user';
import { CurrentUserService } from 'src/app/services/currentUser/current-user.service';
import { Router } from '@angular/router';
import { CourseByInTake } from 'src/app/models/course-by-in-take';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-apply-admission',
  templateUrl: './apply-admission.component.html',
  styleUrls: ['./apply-admission.component.css']
})
export class ApplyAdmissionComponent implements OnInit {

  currentUser : User;
  selectedCourseByInTake : CourseByInTake;
  isLoading = false;
  isSubmitted = false;
  isError = false;

  constructor(private apiService:ApiService,
              private currentUserService:CurrentUserService,
              private router : Router) {

                let currentNavigation = this.router.getCurrentNavigation();
                this.selectedCourseByInTake = currentNavigation.extras.state["item"];
                
              }

  ngOnInit(): void {

      this.currentUserService.getCurrentUser_async().subscribe(user =>{
          if(user == null)
            return;

            this.currentUser = user;
      })
  }

  continueToApply(){
    this.isLoading = true;
    this.isError = false;
    this.isSubmitted = false;
    
    let newApplication : AdmissionApplication = {
      user : {id: this.currentUser.id},
      courseByInTake : { id : this.selectedCourseByInTake.id }   
    };

    this.apiService.postApplicationForAdmission(newApplication).pipe(delay(3000)).subscribe(resp =>{
      this.isLoading = false;

      if(resp.ok){
        this.isSubmitted = true;
      }else{
        this.isError = true;
      }

    },err =>{
      this.isLoading = false;
      this.isError = true;
    })
  }

}
