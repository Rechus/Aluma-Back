import { TestBed } from '@angular/core/testing';

import { ActividadesOffService } from './actividades-off.service';

describe('ActividadesOffService', () => {
  let service: ActividadesOffService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActividadesOffService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
