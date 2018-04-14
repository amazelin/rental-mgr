package com.nilezam.rentalmgr.model.booking.status;

import org.junit.Assert;
import org.junit.Test;


public class StatusTest {

    @Test
    public void when_SameCode_Expected_Equals() {
        Assert.assertEquals(new Status(StatusCode.CANCELLED, "Foo"), new Status(StatusCode.CANCELLED, "Bar"));
    }

    @Test
    public void when_DifferentCode_Expected_NotEquals() {
        Assert.assertNotEquals(new Status(StatusCode.PENDING, "Foo"), new Status(StatusCode.CANCELLED, "Bar"));
    }

}