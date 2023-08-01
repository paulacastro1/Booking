import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindHotelsComponent } from './find-hotels.component';

describe('FindHotelsComponent', () => {
  let component: FindHotelsComponent;
  let fixture: ComponentFixture<FindHotelsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindHotelsComponent]
    });
    fixture = TestBed.createComponent(FindHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
