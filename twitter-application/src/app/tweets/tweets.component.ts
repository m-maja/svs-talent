import { Component, OnInit } from '@angular/core';
import { GeneralService } from '../general.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-tweets',
  templateUrl: './tweets.component.html',
  styleUrls: ['./tweets.component.css']
})
export class TweetsComponent implements OnInit {

  constructor(private generalService:GeneralService) {
    console.log("Constructor called!");
   }

  tweets:any;
  errors:any;

  ngOnInit() {
    this.loadUsers();
    console.log("ngOnInit called!");
  }

  loadUsers(){
    this.generalService.getAllTweets()
    .subscribe(data=>this.tweets = data, error => this.errors = error);
  }

}
