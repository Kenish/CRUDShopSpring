

import {Component, OnInit} from "@angular/core";
import {IUser} from "./user";
import {userLoginService} from "./userLogin.service";
@Component({
    templateUrl: 'app/user/user-page.component.html',
    providers:[userLoginService]
})
export class UserPageComponent implements OnInit{
    user:IUser;
    pageTitle: string = 'user';
    isLogged:Boolean=false;

    constructor(private _userLoginService:userLoginService){
    }

    ngOnInit(): void {
        this._userLoginService.getUser('admin','admin1')
            .subscribe(user=> this.user = user);
}
}