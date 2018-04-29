package com.nilezam.rentalmgr.persistence.booking;

import com.nilezam.rentalmgr.model.booking.Booking;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingSpecificationTest {


    @Test
    public void whenDateBetween_thenReturnTrue(){
        final BookingSpecification.StartDateAndEndDateBetween spec = new BookingSpecification.StartDateAndEndDateBetween(LocalDate.of(2018, 2, 2), LocalDate.of(2018, 3, 1));

        Booking booking = new Booking.BookingBuilder().startDate(LocalDate.of(2018, 2, 10)).endDate(LocalDate.of(2018, 2, 20)).createDate(LocalDateTime.now()).build();

        Assert.assertTrue(spec.isSpecifiedBy(booking));
    }


}