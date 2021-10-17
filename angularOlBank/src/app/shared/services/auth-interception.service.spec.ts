import { TestBed } from '@angular/core/testing';

import { AuthInterceptionService } from './auth-interception.service';

describe('AuthInterceptionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthInterceptionService = TestBed.get(AuthInterceptionService);
    expect(service).toBeTruthy();
  });
});
