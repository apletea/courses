package controllers;

import domain.Booking;
import domain.Timetable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookingDAO;
import repository.BookingDAO.*;
import repository.SessionDAO.*;
import repository.TimetableDAO;

import java.util.List;

/**
 * Created by apletea on 9.2.17.
 */
@RestController
public class Controller {


    @RequestMapping(value = "/api/timetable", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getTimetable(){
        try{
            Timetable timetable = TimetableDAO.getTimetable();
            return new ResponseEntity<String>(timetable.toString(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/bookinginfo", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getBookingInfo(@RequestParam(value = "id") long id){
        try {
            if (id < 0)
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            BookingDAO bookingDAO = new BookingDAO();
            String bookingInfo = bookingDAO.getInfo(id);
            return new ResponseEntity<String>(bookingInfo, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/api/bookingcancel", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getBooking(@RequestParam(value = "id") long id){
        try {
            if (id < 0)
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            BookingDAO bookingDAO = new BookingDAO();
            bookingDAO.cancel(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/api/bookplace", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> changeStatus(@RequestParam(value = "session_id") long session_id, @RequestParam(value = "places") List<Integer> places){
        try{
            if (session_id < 0)
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            for (int place: places) {
              BookingDAO.bookPlace(session_id,place);
            }
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}