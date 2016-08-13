package io.hackangel.street.cleaner.security;

/**
 * Created by amylniko on 28.07.2016.
 */
public enum Authorities {

    USER("user"),ADMIN("admin");
    String authority;

    Authorities(String authority) {
        this.authority=authority;
    }
}
