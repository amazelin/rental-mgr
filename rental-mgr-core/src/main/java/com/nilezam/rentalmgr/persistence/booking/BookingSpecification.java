package com.nilezam.rentalmgr.persistence.booking;

import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.persistence.repository.Specification;
import com.nilezam.rentalmgr.persistence.user.UserEntity;

import javax.persistence.criteria.*;
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

    public static class UserEquals implements Specification<Booking, BookingEntity> {
        private final Long userId;

        public UserEquals(Long userId) {
            this.userId = userId;
        }

        @Override
        public boolean isSpecifiedBy(Booking booking) {
            return booking.getUser().getId().equals(userId);
        }

        @Override
        public Predicate toPredicate(Root<BookingEntity> booking, CriteriaBuilder criteriaBuilder) {
            final Join<BookingEntity, UserEntity> users = booking.join(BookingEntity.Columns.OWNER.getLabel(), JoinType.INNER);
            return criteriaBuilder.equal(users.get(UserEntity.Columns.ID.getLabel()), userId);
        }
    }


}
