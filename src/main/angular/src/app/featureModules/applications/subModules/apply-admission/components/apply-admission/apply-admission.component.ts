import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/apis/api.service';
import { CurrentUser } from 'src/app/models/user-role';
import { CurrentUserService } from 'src/app/services/currentUser/current-user.service';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { CourseByInTake } from 'src/app/models/course-by-in-take';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { CustomData } from 'src/app/models/custom-data';

@Component({
  selector: 'app-apply-admission',
  templateUrl: './apply-admission.component.html',
  styleUrls: ['./apply-admission.component.css']
})
export class ApplyAdmissionComponent implements OnInit {

  title = "Apply";
  currentUser : CurrentUser;
  selectedCourseByInTake : CourseByInTake;
  isLoading = false;
  isSubmitted = false;
  canApply = false;
  isError = false;
  admissionApplication : AdmissionApplication = null;

  constructor(private router : Router,
              private apiService:ApiService,
              private currentUserService:CurrentUserService,
              private activatedRoute : ActivatedRoute) {

                let currentNavigation = this.router.getCurrentNavigation();
                this.selectedCourseByInTake = currentNavigation.extras.state["item"];
                if(currentNavigation.extras.state["admissionApplication"]){
                  this.admissionApplication = currentNavigation.extras.state["admissionApplication"];
                }
                console.log(this.activatedRoute);
                this.title = (activatedRoute.snapshot.data as CustomData).title;                
                
              }

  ngOnInit(): void {

      this.isLoading = true;
      this.currentUserService.getCurrentUser_async("applyAdmissions").subscribe(currentUser =>{
        if(currentUser == null)
           return;
              
        this.currentUser = currentUser;
        this.isLoading = false;
            this.chech_canApply();
      })
  }

  continueToApply(){
    this.isLoading = true;
    this.isError = false;
    this.isSubmitted = false;
    
    let newApplication : AdmissionApplication = {
      user : {id: this.currentUser.user.id},
      courseByInTake : { id : this.selectedCourseByInTake.id }   
    };

    this.apiService.postApplicationForAdmission(newApplication).subscribe(resp =>{
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

  chech_canApply(){

    if(this.admissionApplication != null){
        this.canApply = false;
        return;
    }

    this.isLoading = true;
    this.apiService.canUserApplyForAdmissionToCourseByInTakeRecord(this.currentUser.user.id,this.selectedCourseByInTake.id).subscribe(resp =>{
        this.canApply = resp.body as boolean;
        this.isLoading = false;
    },err =>{
        this.isLoading = false;
        this.canApply = false;
    })
  }

}
