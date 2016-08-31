
import {Routes, RouterModule} from "@angular/router";
import {UserPageComponent} from "./user-page";
import {ModuleWithProviders} from "@angular/core";
export const userRoutes:Routes =[
    {path: 'user',component:UserPageComponent}
];
export const userRouting: ModuleWithProviders =
    RouterModule.forChild(userRoutes);
