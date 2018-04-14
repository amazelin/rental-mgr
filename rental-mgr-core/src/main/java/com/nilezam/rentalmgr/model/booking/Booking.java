package com.nilezam.rentalmgr.model.booking;

import com.nilezam.rentalmgr.model.booking.status.Status;
import com.nilezam.rentalmgr.model.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Booking {

    private final Long id;
    private final LocalDateTime creationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private final User owner;
    private Status status;

    public Booking(BookingBuilder bookingBuilder) {
        id = bookingBuilder.id;
        creationDate = LocalDateTime.now();
        startDate = bookingBuilder.startDate;
        endDate = bookingBuilder.endDate;
        owner = bookingBuilder.owner;
        status = bookingBuilder.status;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public User getOwner() {
        return owner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(startDate, booking.startDate) &&
                Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    public static class BookingBuilder {
        private Long id;
        private LocalDate startDate;
        private LocalDate endDate;
        private User owner;
        private Status status;

        public BookingBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BookingBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public BookingBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public BookingBuilder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public BookingBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
