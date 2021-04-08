import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CustomRoutes } from 'src/app/models/custom-data';
import { CheckIdGuard } from '../../guards/checkId/check-id.guard';
import { AdmissionsMainService } from './services/admissions-main.service';

const routes: CustomRoutes = [
  {
    path:"",
    children:
    [
      {
        path:"all",
        loadChildren: () => import("./subModules/all/all.module").then(mod => mod.AllModule),
        data:{module:"admissionsAll"}
      },
      {
        path:"apply",
        loadChildren: () => import("./subModules/apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"admissionApply"}
      },
      {
        path:"applications",
        loadChildren: () => import("./subModules/applications/applications.module").then(mod => mod.ApplicationsModule),
        data:{module:"admissionApplications"}
      },
      {
        path:"",
        redirectTo:"all",
        pathMatch:"full"
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  providers:[AdmissionsMainService],
  exports: [RouterModule]
})
export class AdmissionsRoutingModule { }
