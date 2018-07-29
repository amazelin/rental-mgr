package com.nilezam.rentalmgr.persistence.booking;

import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.model.booking.status.Status;
import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.persistence.ModelEntityMapper;
import com.nilezam.rentalmgr.persistence.user.UserMapper;

public class BookingMapper implements ModelEntityMapper<Booking, BookingEntity> {

    @Override
    public Booking toModel(BookingEntity from) {
        UserMapper userMapper = new UserMapper();

        return new Booking.BookingBuilder()
                .id(from.getId())
                .createDate(from.getCreationDateTime())
                .startDate(from.getStartDate())
                .endDate(from.getEndDate())
                .status(new Status(from.getStatus().getStatusCode(), from.getStatus().getLabel()))
                .user(new User.Builder().id(from.getOwner().getId()).build())
                .build();
    }

    @Override
    public BookingEntity toEntity(Booking from) {
        return null;
    }
}
