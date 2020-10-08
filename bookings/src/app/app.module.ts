import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { BookingService } from './bookingservice';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';
import { HomeComponent } from './home/home.component';
import { viewbookingbyidComponent } from './viewbookingbyid/viewbookingbyid.component';


@NgModule({
  declarations: [
    AppComponent,
    AddBookingComponent,
    ViewbookingComponent,
    HomeComponent,
    viewbookingbyidComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [BookingService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
