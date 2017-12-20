import { Component, OnInit } from '@angular/core';
import { GeneralService } from '../general.service';
import { error } from 'selenium-webdriver';
import { ActivatedRoute } from '@angular/router/src/router_state';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {

  constructor(private generalService:GeneralService) {
    console.log("Constructor called!");
   }

  users:any;
  errors:any;

  ngOnInit() {
    this.loadUsers();
    console.log(this.users);
    console.log("ngOnInit called!");
  }

  loadUsers(){
    this.generalService.getUsers()
    .subscribe(data=>this.users = data, error => this.errors = error);
  }

}
