import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  constructor() { }
  
getFinalChildFromActivatedRoute(activateRoute : ActivatedRoute):ActivatedRouteSnapshot{
      let firstChild = activateRoute.snapshot.firstChild;
      let finalChild :ActivatedRouteSnapshot;
    
    while(true){
      if(firstChild != null && firstChild.firstChild != null){
          firstChild = firstChild.firstChild;
          continue;
      }else{
        finalChild = firstChild;
        break;
      }
    }

    return finalChild;
  }
}
