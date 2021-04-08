import { TestBed } from '@angular/core/testing';

import { AllAdmissionsService } from './all-admissions.service';

describe('AllAdmissionsService', () => {
  let service: AllAdmissionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllAdmissionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
