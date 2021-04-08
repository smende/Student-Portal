import { Injectable } from '@angular/core';
import { CourseByInTake, CourseByInTakeListByInTake } from 'src/app/models/course-by-in-take';
import { ApiService } from 'src/app/services/apis/api.service';
import { map } from 'rxjs/operators'

@Injectable()
export class AllAdmissionsService {

  constructor(private apiService:ApiService) {
  }

  getCoursesByInTake(){
    return this.apiService.getAllCoursesByInTake().pipe(map(resp =>{
      if(resp.ok && resp.body != null){
          let mapByInTakeId : Map<number,CourseByInTakeListByInTake> = new Map();
          let data = resp.body as CourseByInTake[];
         
          data.forEach(courseByInTake =>{
              if(!mapByInTakeId.has(courseByInTake.inTake.id))
              {
                let copyOfCourseByInTake:CourseByInTake = JSON.parse(JSON.stringify(courseByInTake));

                let courseByInTakeListByInTake: CourseByInTakeListByInTake = Object.assign({},{inTake:copyOfCourseByInTake.inTake,courseByInTakeList:[]});
                    mapByInTakeId.set(courseByInTake.inTake.id,courseByInTakeListByInTake);
              }
            
              mapByInTakeId.get(courseByInTake.inTake.id).courseByInTakeList.push(courseByInTake);              
          })    
          
          return {ok:true,body:Array.from(mapByInTakeId.values())}
      }else{
        return {ok:false,body:[]};
      }
    }))
  }
}
