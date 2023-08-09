import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddHotelsComponent } from './add-hotels/add-hotels.component';
import { FindHotelsComponent } from './find-hotels/find-hotels.component';
import { ShowReservationsComponent } from './show-reservations/show-reservations.component';
import { HotelsComponent } from './hotels/hotels.component';
import { EditHotelComponent } from './edit-hotel/edit-hotel.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { UsersComponent } from './users/users.component';

const appRoute: Routes = [
  {path:'', component: HomeComponent}, 
  {path:'app-navbar', component: NavbarComponent},
  {path:'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'add-hotel', component: AddHotelsComponent}, //solo root
  {path: 'find-hotel', component: FindHotelsComponent}, //user loggeado
  {path: 'show-reservations', component: ShowReservationsComponent}, //user loggeado
  {path: 'hotels', component: HotelsComponent}, //solo root
  {path: 'book', component: ReservationsComponent}, //user loggeado
  {path: 'edit-hotel/:id', component: EditHotelComponent}, //solo root
  {path: 'users', component: UsersComponent } //solo root
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    AddHotelsComponent,
    FindHotelsComponent,
    ShowReservationsComponent,
    HotelsComponent,
    EditHotelComponent,
    ReservationsComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule.forRoot(appRoute ),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
