import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'; 
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../material-module/material.module';
import { LoaderComponent } from './components/loader/loader.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [LoaderComponent],
  imports:[CommonModule,MaterialModule],
  exports:[
    FormsModule,
    HttpClientModule,
    RouterModule,
    MaterialModule,
    LoaderComponent
  ]
})
export class BasicImportModule { }
