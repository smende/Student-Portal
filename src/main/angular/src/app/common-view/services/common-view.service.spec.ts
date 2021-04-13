import { TestBed } from '@angular/core/testing';

import { CommonViewService } from './common-view.service';

describe('CommonViewService', () => {
  let service: CommonViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommonViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
