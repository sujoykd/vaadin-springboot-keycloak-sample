package org.vaadin.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "keycloak")
public record KeycloakProperties(
        String serverUrl,
        String realm,
        String registration,
        String loginUrl,
        String appBaseUrl) {
}