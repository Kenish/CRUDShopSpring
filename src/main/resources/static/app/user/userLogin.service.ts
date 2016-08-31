
import {Injectable} from "@angular/core";
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/do';
import {IUser} from "./user";
@Injectable()
export class userLoginService{
    private _userLink = 'api/users';

    constructor(private _authHttp:Http){ }

    getUser(login:String,_password:String):Observable<IUser>{
        var headers = new Headers();
        let credentials:String =  window.btoa(login+':'+_password);
        headers.append('Authorization','Basic '+credentials);


        return this._authHttp.get(this._userLink,{headers:headers})
            .map((data) => <IUser>data.json())
            .do(data => console.log(JSON.stringify(data)))
    }

}

