package com.nilezam.rentalmgr.web.booking;


import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.persistence.booking.BookingRepository;
import com.nilezam.rentalmgr.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value="/bookings/{bookingId}")
    public ResponseEntity<Booking> getBookings(@PathVariable Long bookingId) {
        return bookingRepository.get(bookingId)
                .map(booking -> new ResponseEntity<>(booking, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public ResponseEntity<Booking> addBooking(@RequestBody BookingForm bookingForm) {
        userRepository.get(bookingForm.getUserId()).map(user -> saveBooking(bookingForm));

        return null;

    }

    private Booking saveBooking(@RequestBody BookingForm bookingForm) {
        return bookingRepository.add(new Booking.BookingBuilder().startDate(bookingForm.getStartDate()).build());
    }
}
