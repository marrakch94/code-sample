import { TestBed } from '@angular/core/testing';

import { ContradictoryAuthGuardService } from './contradictory-auth-guard.service';

describe('ContradictoryAuthGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContradictoryAuthGuardService = TestBed.get(ContradictoryAuthGuardService);
    expect(service).toBeTruthy();
  });
});
