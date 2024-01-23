package Modules;

import Payload.Request.Bookingdates;
import Payload.Request.Bookings;
import Payload.Response.Bookingresponse;
import Utils.Fakerutils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class payloadManager {

    ObjectMapper objectmapper;
    public String createpayload() throws JsonProcessingException {

     objectmapper = new ObjectMapper();

        Bookings Booking =new Bookings();
        Booking.setFirstname(Fakerutils.getusers());
        Booking.setLastname("Butter");
        Booking.setTotalprice(1233);
        Booking.setDepositpaid(true);
        Booking.setAdditionalneeds("Dinner");

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2023-04-22");
        bookingdate.setCheckout("2023-04-30");

        Booking.setBookingdates(bookingdate);

       String payload = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(Booking);
       return payload;



    }

    public Bookingresponse JsontoObject(String jsonstring) throws JsonProcessingException{
        objectmapper = new ObjectMapper();
        Bookingresponse booking_Response = objectmapper.readValue(jsonstring,Bookingresponse.class);
        return booking_Response;

    }

}
