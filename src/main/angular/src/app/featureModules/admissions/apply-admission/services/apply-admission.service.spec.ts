import { TestBed } from '@angular/core/testing';

import { ApplyAdmissionService } from './apply-admission.service';

describe('ApplyAdmissionService', () => {
  let service: ApplyAdmissionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApplyAdmissionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
