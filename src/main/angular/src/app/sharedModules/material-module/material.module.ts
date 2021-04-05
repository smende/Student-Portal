import { NgModule } from '@angular/core';
import { MatButtonModule} from '@angular/material/button';
import { MatListModule} from '@angular/material/list';
import { MatDividerModule} from '@angular/material/divider';
import { MatExpansionModule} from '@angular/material/expansion';
import { MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [],
  exports:[
    MatButtonModule,
    MatListModule,
    MatDividerModule,
    MatExpansionModule,
    MatCardModule
  ]
})
export class MaterialModule { }
