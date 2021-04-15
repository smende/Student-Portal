import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CustomRoutes } from 'src/app/models/custom-data';
import { CheckIdGuard } from '../../guards/checkId/check-id.guard';

const routes: CustomRoutes = [
  {
    path:"",
    children:
    [
      {
        path:"",
        loadChildren: () => import("./subModules/all/all.module").then(mod => mod.AllModule),
        data:{module:"admissionsAll"}
      },
      {
        path:"apply",
        loadChildren: () => import("./subModules/apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"admissionApply"}
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmissionsRoutingModule { }
