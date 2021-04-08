import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApplicationsComponent } from './components/applications/applications.component';
import { CustomRoutes } from 'src/app/models/custom-data';
import { RouterModule } from '@angular/router';
import { BasicImportModule } from '../../../../sharedModules/basic-import-module/basic-import.module';

const routes : CustomRoutes = [
  {
    path:"",
    component:ApplicationsComponent,
    data:{title:"Applications"}
  }
];

@NgModule({
  declarations: [ApplicationsComponent],
  imports: [
    CommonModule,
    BasicImportModule,
    RouterModule.forChild(routes)
  ]
})
export class ApplicationsModule { }
