package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.persistence.user.UserSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserSpecificationTest {


    @Test
    public void whenMailEqualSpecification_thenReturnTrue() {

        //Given
        final String mail = "john.doe@anonymous.com";
        User user = new User(1L, "John", "Doe", mail, "123");
        final UserSpecification.MailEqual mailEqual = new UserSpecification.MailEqual(mail);

        //When
        final boolean specified = mailEqual.isSpecifiedBy(user);

        //Then
        assertTrue(specified);
    }


}