import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  members: {id: number, name: string, position: string}[] = [];
  x: number;
  constructor(private router: Router) {
    this.members.push({id: 1, name: "Charbel", position: "CEO"});
    this.members.push({id: 2, name: "Joe", position: "CTO"});
    this.x = 2;
  }

  goToTab2(){
    this.router.navigate(["/tabs/tab2"]);
  }

}
