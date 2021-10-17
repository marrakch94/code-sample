import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.css']
})
export class ChipsComponent implements OnInit {

  @Output() onClose = new EventEmitter<any>();
  constructor() { }

  ngOnInit(): void {
  }

  close(){
    this.onClose.emit('close');
  }
}
