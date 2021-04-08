import { TestBed } from '@angular/core/testing';

import { AdmissionsMainService } from './admissions-main.service';

describe('AdmissionsMainService', () => {
  let service: AdmissionsMainService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdmissionsMainService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
