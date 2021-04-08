import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAdmissionsComponent } from './all-admissions.component';

describe('AllAdmissionsComponent', () => {
  let component: AllAdmissionsComponent;
  let fixture: ComponentFixture<AllAdmissionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllAdmissionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllAdmissionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
