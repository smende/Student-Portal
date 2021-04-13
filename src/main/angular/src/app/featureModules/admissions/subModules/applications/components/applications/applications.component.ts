import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { CurrentUser } from 'src/app/models/user-role';
import { ApiService } from 'src/app/services/apis/api.service';
import { CurrentUserService } from 'src/app/services/currentUser/current-user.service';

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.css']
})
export class ApplicationsComponent implements OnInit {

  title = "Applications";
  isLoading = false;
  currentUser : CurrentUser;
  isAdminRelatedRole : boolean = false;
  applications : AdmissionApplication[] =[];
  sizeList = [10, 25, 100];
  dataSource : MatTableDataSource<AdmissionApplication> = null;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  keyValues = {
    "id":{name:"id",label:"ID"},
    "applicantName":{name:"applicantName",label:"Applicant Name (ID)",canShow:this.isAdminRelatedRole},
    "course":{name:"course",label:"Course",},
    "inTake":{name:"inTake",label:"In Take"},
    "createdDate":{name:"createdDate",label:"Applied on"},
    "updatedDate":{name:"updatedDate",label:"Last updated on"},
    "status":{name:"status",label:"Status"},
    "notes":{name:"notes",label:"Notes"},
    "actions":{name:"actions",label:"Actions"}
  };

  displayedColumns = Object.keys(this.keyValues);
  
  constructor(private currentUserService: CurrentUserService,
              private apiService : ApiService,
              private router:Router) { }

  ngOnInit(): void {

    this.currentUserService.getCurrentUser_async("allApplications").subscribe(currentUser =>{
      if(currentUser == null)
         return;
            
      this.currentUser = currentUser;
      this.isAdminRelatedRole = this.currentUserService.isCurrentRoleAdminReleatedRole();
          this.loadApplications();
    })

  }

loadApplications(){
  this.isLoading = true;
    this.apiService.getAllAdmissionApplications(this.isAdminRelatedRole ? null : this.currentUser.user.id).subscribe(resp =>{
        if(resp.ok && resp.body != null){
            this.postLoadingRecords(resp.body as any);
        }else{
            this.postLoadingRecords([]);
        }
    },err =>{
      this.postLoadingRecords([]);
    })
}

postLoadingRecords(list:AdmissionApplication[]){
  this.isLoading = false;
  this.dataSource = new MatTableDataSource(list);
  this.dataSource.paginator = this.paginator;
  this.dataSource.sort = this.sort;
}


withdraw(applicationId:number){
  let canDo = window.confirm("Are you sure, you wanna withdraw?");
  
  if(!canDo)
    return;

  this.isLoading = true;
  this.apiService.withdrawAdmissionApplication(applicationId).subscribe(resp =>{
    this.isLoading = false;
      if(resp.ok){
          this.loadApplications();
      }
  },err =>{
    this.isLoading = false;
  })
}

view(application:AdmissionApplication){
  this.router.navigateByUrl("/admissions/apply",{state:{item:application.courseByInTake}});
}

edit(application:AdmissionApplication){

}

}
