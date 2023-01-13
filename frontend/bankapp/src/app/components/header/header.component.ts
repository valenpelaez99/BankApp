import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToHome(){
    this.router.navigate(['home']);
  }

  goToClients(){
    this.router.navigate(['clients']);
  }

  goToProfile(){
    this.router.navigate(['info']);
  }

}
