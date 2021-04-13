import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BasicImportModule} from '../sharedModules/basic-import-module/basic-import.module';

import { TopNavBarComponent } from './components/top-nav-bar/top-nav-bar.component';
import { SideNavBarComponent } from './components/side-nav-bar/side-nav-bar.component';
import { CommonViewService } from './services/common-view.service';

@NgModule({
  declarations: [TopNavBarComponent, SideNavBarComponent],
  imports: [
    CommonModule,
    BasicImportModule
  ],
  providers:[CommonViewService],
  exports:[TopNavBarComponent,SideNavBarComponent]
})
export class CommonViewModule { }
