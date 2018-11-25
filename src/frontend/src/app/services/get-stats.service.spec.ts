import { TestBed, inject } from '@angular/core/testing';

import { GetStatsService } from './get-stats.service';

describe('GetStatsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetStatsService]
    });
  });

  it('should be created', inject([GetStatsService], (service: GetStatsService) => {
    expect(service).toBeTruthy();
  }));
});
