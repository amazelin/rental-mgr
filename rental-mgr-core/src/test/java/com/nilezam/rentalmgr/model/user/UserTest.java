package com.nilezam.rentalmgr.model.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Test
    public void whenSameMail_thenEquals() {
        //Given
        User john= new User(1L, "John", "Doe", "john.doe@anonymous.com", "123");
        User jane = new User(2L, "Jane", "Doe", "john.doe@anonymous.com", "123");

        //When
        final boolean equals = john.equals(jane);

        //Then
        assertTrue(equals);
    }
}