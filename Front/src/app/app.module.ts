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

const appRoute: Routes = [
  {path:'', component: HomeComponent},
  {path:'app-navbar', component: NavbarComponent},
  {path:'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'add-hotel', component: AddHotelsComponent},
  {path: 'find-hotel', component: FindHotelsComponent},
  {path: 'show-reservations', component: ShowReservationsComponent},
  {path: 'hotels', component: HotelsComponent},
  {path: 'book', component: ReservationsComponent},
  {path: 'edit-hotel/:id', component: EditHotelComponent}
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
    ReservationsComponent
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
