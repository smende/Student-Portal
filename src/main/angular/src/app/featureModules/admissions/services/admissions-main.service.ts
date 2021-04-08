import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { ApiService } from 'src/app/services/apis/api.service';

@Injectable()
export class AdmissionsMainService {

  constructor(private apiService:ApiService) { }

  getAdmissionsApplicationsMap(userId:number){
    return this.apiService.getAdmissionApplicationsByUserId(userId).pipe(map(resp =>{
  
      if(resp.ok && resp.body != null){
          let map = new Map<number,AdmissionApplication>();
          (resp.body as AdmissionApplication[]).forEach(a => map.set(a.courseByInTake.id,a));
          return {ok:true,body:map};
      }
        return resp;
    }))
  }
  
}
