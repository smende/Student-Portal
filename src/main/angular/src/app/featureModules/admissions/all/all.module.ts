import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BasicImportModule } from 'src/app/sharedModules/basic-import-module/basic-import.module';
import { CustomRoutes } from 'src/app/models/custom-data';
import { AllAdmissionsComponent } from './components/all-admissions/all-admissions.component';
import { ApplyAdmissionService } from '../apply-admission/services/apply-admission.service';

let routes:CustomRoutes = [
  {
    path:"",
    component:AllAdmissionsComponent,
    data:{title:"All Admission"}
  }
] 

@NgModule({
  declarations: [AllAdmissionsComponent],
  providers:[ApplyAdmissionService],
  imports: [
    CommonModule,
    BasicImportModule,
    RouterModule.forChild(routes)
  ],
  exports:[
    RouterModule
  ]
})
export class AllModule { }
