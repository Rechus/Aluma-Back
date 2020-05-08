import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadHomeComponent } from './actividad-home.component';

describe('ActividadHomeComponent', () => {
  let component: ActividadHomeComponent;
  let fixture: ComponentFixture<ActividadHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActividadHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
