package com.nilezam.rentalmgr.web;


import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.persistence.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @RequestMapping(value="/bookings/{bookingId}")
    public ResponseEntity<Booking> getBookings(@PathVariable Long bookingId) {

        bookingRepository.get(bookingId);

        return null;

    }
}
