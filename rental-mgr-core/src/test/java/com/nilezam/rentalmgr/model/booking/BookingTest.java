package com.nilezam.rentalmgr.model.booking;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BookingTest {

    private static Booking booking= new Booking.BookingBuilder().startDate(LocalDate.of(2018, Month.JANUARY, 1)).endDate(LocalDate.of
            (2018, Month.JANUARY, 15)).build();


    @Test
    public void when_Null_Expect_NotEquals(){
        Assert.assertNotEquals(booking, null);
    }

    @Test
    public void when_WrongStartDate_Expect_NotEquals() {
        Booking tested = new Booking.BookingBuilder().startDate(LocalDate.of(2018, Month.JANUARY, 2)).endDate
                (LocalDate.of(2018, Month.JANUARY, 15)).build();

        Assert.assertNotEquals(booking,tested);

    }

    @Test
    public void when_sameDates_Expect_Equals() {
        Booking tested = new Booking.BookingBuilder().startDate(LocalDate.of(2018, Month.JANUARY, 1)).endDate
                (LocalDate.of(2018, Month.JANUARY, 15)).build();

        Assert.assertEquals(booking,tested);

    }

}