package com.nilezam.rentalmgr.persistence.booking;

import com.nilezam.rentalmgr.model.booking.Booking;
import com.nilezam.rentalmgr.persistence.repository.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookingRepository  extends AbstractJpaRepository<Booking , BookingEntity> {


    public BookingRepository(EntityManager entityManager) {
        super(BookingEntity.class, null, entityManager);
    }
}
