package com.nilezam.rentalmgr.web.security;

import io.jsonwebtoken.Jwts;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


/**
 * Spring security Filter processing each request Authorization header and validating user JWT token
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader(JWTConstants.AUTHORIZATION_HEADER);

        if (token == null || !token.startsWith(JWTConstants.TOKEN_PREFIX)) {
            chain.doFilter(request,response);
            return;
        }
        token = token.replaceFirst(JWTConstants.TOKEN_PREFIX, Strings.EMPTY);

        if (token != null) {
            String userName = Jwts.parser().setSigningKey(JWTConstants.SECRET.getBytes()).parseClaimsJws(token)
                    .getBody().getSubject();

            if (userName != null) {

                UsernamePasswordAuthenticationToken authenticationToken = new
                        UsernamePasswordAuthenticationToken(userName, null, Collections.EMPTY_LIST);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
        }
        chain.doFilter(request,response);
    }
}
