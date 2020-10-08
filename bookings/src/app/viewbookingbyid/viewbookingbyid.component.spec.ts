import { ComponentFixture, TestBed } from '@angular/core/testing';

import { viewbookingbyidComponent } from './viewbookingbyid.component';

describe('ViewbookingByIdComponent', () => {
  let component: viewbookingbyidComponent;
  let fixture: ComponentFixture<viewbookingbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ viewbookingbyidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(viewbookingbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
