import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  displayPosition: boolean = false;
  position: string = '';
  responsiveOptions;

  images: string[] = ["/assets/2.png","/assets/6.jpeg","/assets/3.png","/assets/4.jpg","/assets/5.jpg","/assets/7.jpg","/assets/1.png"];

  constructor() {
    this.responsiveOptions = [
      {
        breakpoint: '1024px',
        numVisible: 3,
        numScroll: 3,
      },
      {
        breakpoint: '768px',
        numVisible: 2,
        numScroll: 2,
      },
      {
        breakpoint: '560px',
        numVisible: 1,
        numScroll: 1,
      },
    ];
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
