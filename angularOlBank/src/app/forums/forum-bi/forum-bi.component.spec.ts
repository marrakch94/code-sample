import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumBiComponent } from './forum-bi.component';

describe('ForumBiComponent', () => {
  let component: ForumBiComponent;
  let fixture: ComponentFixture<ForumBiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForumBiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumBiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
