package com.dev.ecommerce.config;

public class SecurityConstants {
    static final String SECRET = "MeuEcommerce";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/login";
    static final long EXPIRATION_TIME = 86400000L;
}
