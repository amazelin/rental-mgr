package com.nilezam.rentalmgr.model.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

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
       final User userResult = userRepository.get(new UserSpecification.MailEqual(testMail));

        //then
        assertEquals(userResult.getLastName(), "Doe");
    }

}