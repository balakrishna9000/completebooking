import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { HomeComponent } from './home/home.component';
import { viewbookingbyidComponent } from './viewbookingbyid/viewbookingbyid.component';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';

const routes: Routes = [
  {path:"home",component :HomeComponent},
  {path:"add-booking",component :AddBookingComponent},
  {path:"viewbookingById",component :viewbookingbyidComponent},
   {path:"viewbooking",component :ViewbookingComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
