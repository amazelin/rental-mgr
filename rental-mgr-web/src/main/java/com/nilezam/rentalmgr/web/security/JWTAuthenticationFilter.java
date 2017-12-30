package com.nilezam.rentalmgr.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Arnaud on 26/11/2017.
 * Spring security filter processing user authentication based on submitted credentials
 * This filter responds to /login URL
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse) throws AuthenticationException {


        //Get credentials from POST values
        AuthenticationCredentials credentials;
        try {
            credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(),
                    AuthenticationCredentials.class);
        } catch (IOException e) {
            throw new InvalidCredentialsException(e.getMessage());
        }

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(credentials.getLogin()
                , credentials.getPassword(), Collections.EMPTY_LIST));


    }

    /**
     * Override default successfulAuthentication method in order to add JWT in response header
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain
            chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder().setSubject(((User) authResult.getPrincipal()).getUsername()).setExpiration(new Date
                (System.currentTimeMillis() + JWTConstants.TOKEN_EXPIRATION_TIME)).signWith(SignatureAlgorithm.ES256,
                JWTConstants.SECRET.getBytes()).compact();

        response.addHeader(JWTConstants.AUTHORIZATION_HEADER, JWTConstants.TOKEN_PREFIX + token);


    }

    private static class InvalidCredentialsException extends AuthenticationException {

        InvalidCredentialsException(String msg, Throwable t) {
            super(msg, t);
        }

         InvalidCredentialsException(String msg) {
            super(msg);
        }
    }


}
