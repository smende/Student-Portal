import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
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
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ApplicationsRoutingModule { }
