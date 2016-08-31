import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {UserPageComponent} from "./user-page";
import {userLoginService} from "./userLogin.service";
import { userRouting} from "./user.routing";
import {BrowserModule} from "@angular/platform-browser";
import {SharedModule} from "../shared/shared.module";
@NgModule({
    imports: [
        userRouting,
        BrowserModule,
        SharedModule
    ],
    declarations: [
        UserPageComponent,
    ],
    providers: [
        userLoginService,
    ]
})
export class userModule { }