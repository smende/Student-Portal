import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'roleView'
})
export class RoleViewPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {

    if(value != undefined && value != null){
        let r = value.replace(/ROLE/g,'').replace(/_/g,' ').trim();
        return r;
    }
    return "";
  }

}
