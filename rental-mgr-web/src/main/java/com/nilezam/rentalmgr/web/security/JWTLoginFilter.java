package com.nilezam.rentalmgr.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by Arnaud on 26/11/2017.
 * Spring security filter
 *
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse) throws AuthenticationException, IOException, ServletException {


        //Get credentials from POST values
        AuthenticationCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(),
                AuthenticationCredentials.class);

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(credentials.getLogin()
                , credentials.getPassword(), Collections.EMPTY_LIST));


    }

}
