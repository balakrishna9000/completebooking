import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { BookingService } from '../bookingservice';
import { Booking } from '../model/booking';

@Component({
  selector: 'app-viewbookingid',
  templateUrl: './viewbookingbyid.component.html',
  styleUrls: ['./viewbookingbyid.component.css']
})
export class viewbookingbyidComponent {
  bookings:Booking[];
  //viewbookingById: any;
  constructor(private router: ActivatedRoute ,private bookingService:BookingService) {
    let observable = router.paramMap;
    observable.subscribe((params:ParamMap)=>{
      let bookingidVal:string =params.get("id");
    let bookingid:number=Number(bookingidVal);//converting string to number
    console.log("id available is "+bookingid);
    this.viewbookingbyid(bookingid);     
   })
   }


   viewbookingbyid(id:number){
    let observable:Observable<Booking[]>=this.bookingService.getBooking(id);
    observable.subscribe(    
      userArg=>{
        this.bookings=userArg;
      },

      err=>{
        console.log("inside booking details, err is "+err.message);
      }
    ); 
   }

   viewBookingById(form:any){
    let data=form.value;
    let id=data.bookingid;
   this.viewbookingbyid(id);
  }  
}
