import { Injectable } from '@angular/core';
import { AdmissionApplication } from 'src/app/models/admission-application';
import { ApiService } from 'src/app/services/apis/api.service';

@Injectable()
export class ApplyAdmissionService {

  constructor(private apiService:ApiService) {
  }

  postApplicationForACourse(newRecord:AdmissionApplication){
      return this.apiService.postApplicationForAdmission(newRecord).subscribe(resp =>{
        console.log(resp);
      })
  }
  
}
