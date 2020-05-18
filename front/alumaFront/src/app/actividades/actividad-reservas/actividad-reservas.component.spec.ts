import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadReservasComponent } from './actividad-reservas.component';

describe('ActividadReservasComponent', () => {
  let component: ActividadReservasComponent;
  let fixture: ComponentFixture<ActividadReservasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActividadReservasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadReservasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
