package com.nilezam.rentalmgr.config;

import com.nilezam.rentalmgr.web.security.JWTLoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Arnaud on 26/11/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);


        http.csrf().disable().
            authorizeRequests().
                antMatchers(HttpMethod.POST, "/users/subscribe").permitAll().
                antMatchers(HttpMethod.POST, "users/login").permitAll().
                anyRequest().authenticated().
            and().
                //Add login filter verifying user login / password and generating JWT token
                addFilterBefore(new JWTLoginFilter("/login"), authenticationManager(), UsernamePasswordAuthenticationFilter.class).
                addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

        ;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);

        //auth.userDetailsService();
    }
}
