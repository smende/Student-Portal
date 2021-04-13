import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit {

  @Input() isLoading = false;
  @Input() diameter = 150;
  @Input() strokeWidth = 2;
  @Input() label : string = null;

  constructor() { }

  ngOnInit(): void {
  }

}
