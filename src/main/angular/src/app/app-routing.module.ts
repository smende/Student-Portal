import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CustomRoutes } from './models/custom-data';

const routes: CustomRoutes = [
  {
    path:"admissions",
    loadChildren: ()=> import("./featureModules/admissions/admissions.module").then(mod => mod.AdmissionsModule),
    data:{standAlone:false}
  },
  {
    path:"applications",
    loadChildren: ()=> import("./featureModules/applications/applications.module").then(mod => mod.ApplicationsModule),
    data:{standAlone:false}
  },
  {
    path:"",
    redirectTo:"admissions",
    pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
