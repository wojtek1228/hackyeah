import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageHotAppointmentsComponent } from './page-hot-appointments.component';

describe('PageHotAppointmentsComponent', () => {
  let component: PageHotAppointmentsComponent;
  let fixture: ComponentFixture<PageHotAppointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageHotAppointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageHotAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
