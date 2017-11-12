package com.nilezam.rentalmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Arnaud on 05/02/2017.
 *
 * SpringBoot bootstrap class. Behave as application main entry point
 *
 */

@SpringBootApplication //equivalent to using combination of @Configuration, @EnableAutoConfiguration and @ComponentScan!
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
