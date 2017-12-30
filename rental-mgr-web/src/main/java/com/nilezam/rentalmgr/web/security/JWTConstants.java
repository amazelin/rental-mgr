package com.nilezam.rentalmgr.web.security;

final class JWTConstants {

    static final String SECRET = "SecretKeyToGenJWTs";
    static final String AUTHORIZATION_HEADER = "Authorization";
    static final String TOKEN_PREFIX = "Bearer ";
    static final long TOKEN_EXPIRATION_TIME = 3_600_000;

}
