package com.nilezam.rentalmgr.persistence.user;

import com.nilezam.rentalmgr.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void whenFindByMail_thenReturnUser() {
        //given
        final String testMail = "john.doe@anonymous.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setMail(testMail);
        userEntity.setPassword("pwd");
        entityManager.persistAndFlush(userEntity);


        //when
       final Optional<User> userResult = userRepository.get(new UserSpecification.MailEqual(testMail));

        //then
        assertEquals(userResult.map(User::getLastName).get(), "Doe");
        assertNotNull(userResult.map(User::getId).get());
    }

}