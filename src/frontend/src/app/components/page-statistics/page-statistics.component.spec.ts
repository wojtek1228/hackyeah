import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageStatisticsComponent } from './page-statistics.component';

describe('PageStatisticsComponent', () => {
  let component: PageStatisticsComponent;
  let fixture: ComponentFixture<PageStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
