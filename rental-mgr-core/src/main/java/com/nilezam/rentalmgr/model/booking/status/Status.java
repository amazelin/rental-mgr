package com.nilezam.rentalmgr.model.booking.status;

import java.util.Objects;

public class Status {
    private final StatusCode status;
    private final String label;

    public Status(StatusCode status, String label) {
        this.status = status;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return status == status1.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(status);
    }

    public StatusCode getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }
}
