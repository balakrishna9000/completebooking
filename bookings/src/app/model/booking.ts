export class Booking{
    // getAllBookings(): import("rxjs").Observable<Booking[]> {
    //   throw new Error('Method not implemented.');
    // }
    // deleteviewbooking(bookingid: number) {
    //   throw new Error('Method not implemented.');
    // }
    // getBooking(bookingId: number): import("rxjs").Observable<Booking> {
    //   throw new Error('Method not implemented.');
    // }
    
    bookingId:number;
    userId:number;
    bookingDate:string;
    ticketCost:number;
    bookingState:string;
    pnrNumber:number;
    scheduleflightId:number;
  getAllBookings: any;

    constructor( bookingId:number,userId:number,bookingDate:string,ticketCost:number, 
      bookingState:string,pnrNumber:number,scheduleflightId:number){
        this.bookingId=bookingId;
        this.userId=userId;
        this.bookingDate=bookingDate;
        this.ticketCost=ticketCost;
        this.bookingState=bookingState;
        this.pnrNumber=pnrNumber;
        this.scheduleflightId=scheduleflightId;

    }
        
  
    getUserId():number{
      return this.userId;
    }
  
    getBookingDate():string{
      return this.bookingDate;
    }
    getTicketCost():number{
      return this.ticketCost;
    }
  
    getBookingState():string{
      return this.bookingState;
    }
    getPnrNumber():number{
      return this.pnrNumber;
    }
    getScheduleflightId():number{
      return this.scheduleflightId;
    }

  }
  