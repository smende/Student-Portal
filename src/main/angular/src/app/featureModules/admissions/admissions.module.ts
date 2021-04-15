import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdmissionsRoutingModule } from './admissions-routing.module';
import { AdmissionsMainService } from './services/admissions-main.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AdmissionsRoutingModule
  ],
  providers:[AdmissionsMainService],
})
export class AdmissionsModule { }
