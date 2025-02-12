package org.vaadin.example.util;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.vaadin.example.data.KeycloakUser;

public class UserUtil {
    public static Optional<KeycloakUser> getCurrentUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(KeycloakUser.class::cast);
    }
}
