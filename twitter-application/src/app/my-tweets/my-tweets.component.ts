import { Component, OnInit } from '@angular/core';
import { GeneralService } from '../general.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-my-tweets',
  templateUrl: './my-tweets.component.html',
  styleUrls: ['./my-tweets.component.css']
})
export class MyTweetsComponent implements OnInit {

  constructor(private generalService:GeneralService) {
    console.log("Constructor called!");
   }

  tweets:any;
  errors:any;

  user:any;

  ngOnInit() {
    this.loadMyTweets();
    this.loadUser();
    console.log("ngOnInit called!");
  }

  loadMyTweets(){
    this.generalService.getTweetsOfUserWithId(1)
    .subscribe(data=>this.tweets = data, error => this.errors = error);
  }

  loadUser(){
    this.generalService.getUserById(1)
    .subscribe(data => this.user = data);
  }
  

}
