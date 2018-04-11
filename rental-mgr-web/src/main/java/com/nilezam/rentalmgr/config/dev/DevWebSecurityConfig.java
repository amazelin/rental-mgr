package com.nilezam.rentalmgr.config.dev;

import com.nilezam.rentalmgr.config.AbstractWebSecurityConfig;
import com.nilezam.rentalmgr.web.security.JWTAuthenticationFilter;
import com.nilezam.rentalmgr.web.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("dev")
public class DevWebSecurityConfig extends AbstractWebSecurityConfig {


    public DevWebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        super(userDetailsService, passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers(HttpMethod.POST, "/users/sign-up").permitAll().
                antMatchers(HttpMethod.POST, "/login").permitAll().
                antMatchers("/h2-console/**").permitAll().
                anyRequest().authenticated().
                and().
                //Add login filter verifying user login / password and generating JWT token
                        addFilter(new JWTAuthenticationFilter(authenticationManager())).
                addFilter(new JWTAuthorizationFilter(authenticationManager()))
                //Disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();
    }
}
