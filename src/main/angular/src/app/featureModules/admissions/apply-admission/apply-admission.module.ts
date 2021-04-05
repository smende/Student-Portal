import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomRoutes } from 'src/app/models/custom-data';
import { RouterModule } from '@angular/router';
import { BasicImportModule } from 'src/app/sharedModules/basic-import-module/basic-import.module';

import { ApplyAdmissionComponent } from './components/apply-admission/apply-admission.component';
import { ApplyAdmissionService } from './services/apply-admission.service';

let routes:CustomRoutes = [
  {
    path:"",
    component:ApplyAdmissionComponent,
    data:{title:"Apply Admission"}
  }
] 

@NgModule({
  declarations: [ApplyAdmissionComponent],
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
export class ApplyAdmissionModule { }
