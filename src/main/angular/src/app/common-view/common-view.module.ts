import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BasicImportModule} from '../sharedModules/basic-import-module/basic-import.module';

import { TopNavBarComponent } from './components/top-nav-bar/top-nav-bar.component';

@NgModule({
  declarations: [TopNavBarComponent],
  imports: [
    CommonModule,
    BasicImportModule
  ],
  exports:[TopNavBarComponent]
})
export class CommonViewModule { }
