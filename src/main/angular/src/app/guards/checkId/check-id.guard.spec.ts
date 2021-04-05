import { TestBed } from '@angular/core/testing';

import { CheckIdGuard } from './check-id.guard';

describe('CheckIdGuard', () => {
  let guard: CheckIdGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CheckIdGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
