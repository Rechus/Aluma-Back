import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadParticipantesComponent } from './actividad-participantes.component';

describe('ActividadParticipantesComponent', () => {
  let component: ActividadParticipantesComponent;
  let fixture: ComponentFixture<ActividadParticipantesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActividadParticipantesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadParticipantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
