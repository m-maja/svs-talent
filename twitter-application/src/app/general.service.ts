import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class GeneralService {

    url:string = "http://localhost:8080/";

    constructor(private http:Http) { }

    getUsers()
    { 
        return this.http.get(this.url+'users')
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        });
    }

    getUserById(id:string){
        return this.http.get(this.url + 'users/user' + id)
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    getUserByUsername(username:string){
        return this.http.get(this.url + 'users/' + username)
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }
    getAllTweets(){
        return this.http.get(this.url + 'tweets/')
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    getTweetsOfUserWithId(id:number){
        return this.http.get(this.url + 'users/' + id + '/tweets')
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    getTweetWithId(id:number){
        return this.http.get(this.url + 'tweets/' + id)
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    createNewUser(username:string){
        return this.http.post(this.url + 'users/', { 'username':username })
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    createNewTweet(content:string, userId:number){
        return this.http.post(this.url + userId + '/tweets/', {'content':content})
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    deleteTweetWithId(id:number){
        return this.http.delete(this.url + 'tweets/' + id)
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }

    deleteUserWithId(id:number){
        return this.http.delete(this.url + 'users/' + id)
        .map((res:Response) => res.json())
        .catch((err:Response) => {
            return Observable.throw(err);
        })
    }
}