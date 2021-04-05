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
        path:"all",
        loadChildren: () => import("./all/all.module").then(mod => mod.AllModule),
        data:{module:"All"}
      },
      {
        path:"apply",
        loadChildren: () => import("./apply-admission/apply-admission.module").then(mod => mod.ApplyAdmissionModule),
        canLoad:[CheckIdGuard],
        canActivateChild:[CheckIdGuard],
        data:{module:"Apply"}
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
  exports: [RouterModule]
})
export class AdmissionsRoutingModule { }
