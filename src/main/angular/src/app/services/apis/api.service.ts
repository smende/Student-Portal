import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdmissionApplication } from 'src/app/models/admission-application';
const API_VERSION = "api";

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  constructor(private http:HttpClient) { }

  getApiVersion(){
    return API_VERSION;
  }
  
  getAllInTakes(){
    return this.http.get(API_VERSION+"/intake",{observe:"response"});
  }

  getAllCourses(){
    return this.http.get(API_VERSION+"/course",{observe:"response"});
  }

  getAllCoursesByInTake(){
    return this.http.get(API_VERSION+"/coursesbyintake",{observe:"response"});
  }

  postApplicationForAdmission(admissionApplication:AdmissionApplication){
    return this.http.post(API_VERSION+"/application",admissionApplication,{observe:"response"});
  }

  getAdmissionApplicationsByUserId(userId:number){
    return this.http.get(API_VERSION+"/application/byuserid/"+userId,{observe:"response"})
  }
  
  canUserApplyForAdmissionToCourseByInTakeRecord(userId : number, courseByInTakeId : number){
    return this.http.get(API_VERSION+"/application/can_user_apply_courseintake",{params:{userid:userId.toString(),coursebyintakeid:courseByInTakeId.toString()},observe:"response"});
  }

  withdrawAdmissionApplication(applicationId:number){
    return this.http.put(API_VERSION+"/application/withdraw",{id:applicationId},{observe:"response"});
  }
}
