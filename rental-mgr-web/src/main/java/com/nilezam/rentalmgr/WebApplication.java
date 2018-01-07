package com.nilezam.rentalmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Arnaud on 05/02/2017.
 *
 * SpringBoot bootstrap class. Behave as application main entry point
 *
 */

@SpringBootApplication //equivalent to using combination of @Configuration, @EnableAutoConfiguration and @ComponentScan!
@Import(CoreApplication.class)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
