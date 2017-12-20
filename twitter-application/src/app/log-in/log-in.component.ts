import { Component, OnInit } from '@angular/core';
import { GeneralService } from '../general.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  user:any;
  username:string;


  constructor(private generalService:GeneralService) {
    console.log("Constructor called!");
   }

  ngOnInit() {
  }

  signIn(){
    this.user = this.generalService.getUserByUsername(this.username);
  }

  signUp(){
    this.user = this.generalService.createNewUser(this.username);
  }
}
