import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'; 
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../material-module/material.module';
import { LoaderComponent } from './components/loader/loader.component';
import { CommonModule } from '@angular/common';
import { RoleViewPipe } from '../../pipes/role-view/role-view.pipe';

@NgModule({
  declarations: [LoaderComponent,RoleViewPipe],
  imports:[CommonModule,MaterialModule],
  exports:[
    FormsModule,
    HttpClientModule,
    RouterModule,
    MaterialModule,
    LoaderComponent,
    RoleViewPipe
  ]
})
export class BasicImportModule { }
