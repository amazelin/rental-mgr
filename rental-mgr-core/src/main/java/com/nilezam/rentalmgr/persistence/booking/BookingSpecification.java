package com.nilezam.rentalmgr.persistence.booking;

import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.persistence.repository.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class BookingSpecification {



    public static class StartDateAndEndDateBetween implements Specification<Booking, BookingEntity>{


        private final LocalDate startDate;
        private final LocalDate endDate;

        public StartDateAndEndDateBetween(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }


        @Override
        public boolean isSpecifiedBy(Booking booking) {
            return booking.getStartDate().compareTo(startDate) >= 0 && booking.getEndDate().compareTo(endDate) <= 0;
        }

        @Override
        public Predicate toPredicate(Root<BookingEntity> object, CriteriaBuilder criteriaBuilder) {
            return null;
        }
    }

}
