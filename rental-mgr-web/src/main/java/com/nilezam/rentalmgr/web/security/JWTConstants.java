package com.nilezam.rentalmgr.web.security;

public final class JWTConstants {

    public static final String USER_ID_HEADER = "X-user-id";
    static final String SECRET = "SecretKeyToGenJWTs";
    static final String AUTHORIZATION_HEADER = "Authorization";
    static final String TOKEN_PREFIX = "Bearer ";
    static final long TOKEN_EXPIRATION_TIME = 3_600_000;

}
