import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CheckIdGuard } from 'src/app/guards/checkId/check-id.guard';
import { CustomRoutes } from 'src/app/models/custom-data';

const routes: CustomRoutes = [
  {
    path:"",
    children:
    [
      {
        path:"",
        loadChildren: () => import("./subModules/applications/applications.module").then(mod => mod.ApplicationsModule),
        data:{module:"admissionApplications"}
      },
      {
        path:"apply",
        loadChildren: () => import("./subModules/apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"applicationsApply",title:"Apply Admission"}
      },
      {
        path:"view/:id",
        loadChildren: () => import("./subModules/apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"applicationsView",title:"View Application"}
      },
      {
        path:"edit/:id",
        loadChildren: () => import("./subModules/apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"applicationsView",title:"Update Application"}
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ApplicationsRoutingModule { }
