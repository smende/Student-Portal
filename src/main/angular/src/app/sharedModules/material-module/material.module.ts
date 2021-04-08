import { NgModule } from '@angular/core';
import { MatButtonModule} from '@angular/material/button';
import { MatListModule} from '@angular/material/list';
import { MatDividerModule} from '@angular/material/divider';
import { MatExpansionModule} from '@angular/material/expansion';
import { MatCardModule} from '@angular/material/card';
import { MatTableModule} from '@angular/material/table';
import { MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatMenuModule} from '@angular/material/menu';
import { MatSidenavModule} from '@angular/material/sidenav';

@NgModule({
  declarations: [],
  exports:[
    MatButtonModule,
    MatListModule,
    MatDividerModule,
    MatExpansionModule,
    MatCardModule,
    MatTableModule,
    MatProgressSpinnerModule,
    MatPaginatorModule,
    MatMenuModule,
    MatSidenavModule
  ]
})
export class MaterialModule { }
