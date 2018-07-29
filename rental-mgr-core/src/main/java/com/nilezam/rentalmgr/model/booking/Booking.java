package com.nilezam.rentalmgr.model.booking;

import com.nilezam.rentalmgr.model.booking.status.Status;
import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.persistence.IdentifierBehavior;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Booking implements IdentifierBehavior {


    private Long id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final User user;
    private Status status;
    private int peopleCount;


    private final LocalDateTime createDate;

    private Booking(BookingBuilder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.user = builder.user;
        this.createDate = builder.createDate;
        this.status = builder.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public static class BookingBuilder {
        private Long id;
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDateTime createDate;
        private User user;
        private Status status;
        private int peopleCount;


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

        public BookingBuilder user(User user) {
            this.user = user;
            return this;
        }

        public BookingBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public BookingBuilder peopleCount(int peopleCount) {
            this.peopleCount = peopleCount;
            return this;
        }

        public BookingBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }


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

    @Override
    public Long getId() {
        return id;
    }
}
