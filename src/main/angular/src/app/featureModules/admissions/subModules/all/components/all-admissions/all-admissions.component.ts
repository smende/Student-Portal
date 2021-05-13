import { Component, OnInit } from '@angular/core';
import { MatSelectionListChange } from '@angular/material/list';
import { Router } from '@angular/router';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { CourseByInTake, CourseByInTakeListByInTake } from 'src/app/models/course-by-in-take';
import { CurrentUser } from 'src/app/models/user-role';
import { CurrentUserService } from 'src/app/services/currentUser/current-user.service';
import { AllAdmissionsService } from '../../services/all-admissions.service';
import { AdmissionsMainService } from '../../../../services/admissions-main.service';

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

  currentUser : CurrentUser;
  isLoading = false;

  records : CourseByInTakeListByInTake[] =[];
  admissionApplicationsMap : Map<number, AdmissionApplication[]> = new Map();

  constructor(private router:Router,
              private currentUserService:CurrentUserService,
              private allAdmissionsService:AllAdmissionsService,
              private admissionsMainService:AdmissionsMainService) { }

  ngOnInit(): void {

      this.currentUserService.getCurrentUser_async("allAdmissions").subscribe(currentUser =>{
        if(currentUser == null)
           return;
              
        this.currentUser = currentUser;
            this.loadAllCoursesByInTakes();
            this.loadAdmissionApplications();
      })

  }

  loadAllCoursesByInTakes(){
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

    this.router.navigateByUrl("/applications/apply",{state:{hasData:true,"item" : directData}});
  }

  loadAdmissionApplications(){
      this.admissionsMainService.getAdmissionsApplicationsMap(this.currentUser.user.id).subscribe(resp =>{
        if(resp.ok && resp.body != null)
            this.admissionApplicationsMap = resp.body as any;
      })
  }

}
 