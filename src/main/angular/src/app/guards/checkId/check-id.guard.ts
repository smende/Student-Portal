import { Injectable } from '@angular/core';
import { CanActivateChild, CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { GenericFields } from 'src/app/models/generic-fields';

@Injectable({
  providedIn: 'root'
})
export class CheckIdGuard implements CanActivateChild, CanLoad {
 
  constructor(private router : Router){ }

  canLoad(route: Route, segments: UrlSegment[]): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    return this.hasCourseByInTakeId();
  }
  
  canActivateChild(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.hasCourseByInTakeId();
  }

  private hasCourseByInTakeId():boolean{
    let result = false;
    if(this.router.getCurrentNavigation().extras && 
      this.router.getCurrentNavigation().extras.state && 
      (this.router.getCurrentNavigation().extras.state["item"] as GenericFields).id != null)
        result = true;
    return result;
  }
  
}
