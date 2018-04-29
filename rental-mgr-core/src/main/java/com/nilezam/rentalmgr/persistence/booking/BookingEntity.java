package com.nilezam.rentalmgr.persistence.booking;


import com.nilezam.rentalmgr.persistence.IdentifierBehavior;
import com.nilezam.rentalmgr.persistence.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "BOOKING")
public class BookingEntity implements IdentifierBehavior {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREATION_DATE_TIME")
    private LocalDateTime creationDateTime;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @OneToOne()
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private UserEntity owner;

    @OneToOne()
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private StatusEntity status;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime dateTime) {
        this.creationDateTime = dateTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }


    public enum Columns {
        ID("id"),
        CREATION_DATE_TIME("creationDateTime"),
        START_DATE("startDate"),
        END_DATE("endDate"),
        OWNER("owner"),
        STATUS("status");

        private final String label;

        Columns(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
