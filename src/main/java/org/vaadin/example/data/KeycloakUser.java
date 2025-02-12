package org.vaadin.example.data;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class KeycloakUser implements OidcUser {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Collection<String> roles;

    private String locale;

    private Collection<? extends GrantedAuthority> authorities;

    @JsonIgnore
    private OidcIdToken idToken;
    private String sessionId;
    private String avatarUrl;
    private String subject;
    private URL issuer;
    @JsonIgnore
    private Map<String, Object> claims;

    public OidcUserInfo getUserInfo() {
        return null;
    }

    public Map<String, Object> getAttributes() {
        return Collections.emptyMap();
    }

    public String getName() {
        return "%s %s".formatted(firstName, lastName);
    }

    public String getLocale() {
        return Optional.ofNullable(locale)
                .map(String::strip)
                .filter(Predicate.not(String::isEmpty))
                .orElse(Locale.ENGLISH.getLanguage());
    }
}
