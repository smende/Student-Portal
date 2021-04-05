import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'; 
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../material-module/material.module';

@NgModule({
  declarations: [],
  exports:[
    FormsModule,
    HttpClientModule,
    RouterModule,
    MaterialModule
  ]
})
export class BasicImportModule { }
