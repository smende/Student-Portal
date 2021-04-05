import { Component, OnInit } from '@angular/core';
import { MatSelectionListChange } from '@angular/material/list';
import { Router } from '@angular/router';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { CourseByInTake, CourseByInTakeListByInTake } from 'src/app/models/course-by-in-take';
import { User } from 'src/app/models/user';
import { CurrentUserService } from 'src/app/services/currentUser/current-user.service';
import { AllAdmissionsService } from '../../services/all-admissions.service';

@Component({
  selector: 'app-all-admissions',
  templateUrl: './all-admissions.component.html',
  styleUrls: ['./all-admissions.component.css']
})
export class AllAdmissionsComponent implements OnInit {

  /**
   * 
   * TODO
   *
   * Lazy load List<Course> by selected InTake
   * 
   */

  currentUser : User;
  isLoading = false;

  records : CourseByInTakeListByInTake[] =[];
  admissionApplicationsMap : Map<number, AdmissionApplication[]> = new Map();

  constructor(private currentUserService:CurrentUserService,
              private allAdmissionsService:AllAdmissionsService,
              private router:Router) { }

  ngOnInit(): void {

      this.currentUserService.getCurrentUser_async().subscribe(user =>{
          if(user == null)
            return;

            this.currentUser = user;
            this.loadAllInTakes();
            this.loadAdmissionApplications();
      })

  }

  loadAllInTakes(){
    this.isLoading = true;
    this.allAdmissionsService.getCoursesByInTake().subscribe(resp =>{
      this.isLoading = false;

      if(resp.ok){
          this.records = resp.body;
      }else{
          this.records = [];
      }

    },err =>{
      this.isLoading = false;
      this.records = [];
    })
  }

  onSelect(selectedCourseByInTake : MatSelectionListChange,directData:CourseByInTake){
    if(this.admissionApplicationsMap.has(directData.id))
    return;

    this.router.navigateByUrl("/admissions/apply",{state:{"item" : directData}});
  }

  loadAdmissionApplications(){
      this.allAdmissionsService.getAdmissionsApplicationsMap(this.currentUser.id).subscribe(resp =>{
        if(resp.ok && resp.body != null)
            this.admissionApplicationsMap = resp.body as any;

            console.log(this.admissionApplicationsMap);
      })
  }

}
 