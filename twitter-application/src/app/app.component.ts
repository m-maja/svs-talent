import { Component , OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  // encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {

  ngOnInit(){
    this.showLogIn();
  }

  showLogIn(){
    console.log("Clicked showLogIn");
    this.hideContent();
    $("#log-in").show();
  }
  showAllUsers(){
    console.log("Clicked showAllUsers()");
    this.hideContent();
    $("#users").show();
  }

  showAllTweets(){
    console.log("Clicked showAllTweets");
    this.hideContent();
    $("#tweets").show();
  }

  showMyTweets(){
    console.log("Clicked showMyTweets()");
    this.hideContent();
    $("#my-tweets").show();
  }

  hideContent(){
    $("#users").hide();
    $("#tweets").hide();
    $("#my-tweets").hide();
    $("#log-in").hide();
  }
}
