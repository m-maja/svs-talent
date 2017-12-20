import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { GeneralService } from './general.service';
import { TweetsComponent } from './tweets/tweets.component';
import { MyTweetsComponent } from './my-tweets/my-tweets.component';
import { LogInComponent } from './log-in/log-in.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    TweetsComponent,
    MyTweetsComponent,
    LogInComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
  ],
  providers: [GeneralService],
  bootstrap: [AppComponent]
})
export class AppModule { }
