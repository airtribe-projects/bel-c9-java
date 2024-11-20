package org.airtribe.authorization_server.config;

import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;


@Configuration
public class ClientConfig {

  @Bean
  public RegisteredClientRepository registeredClientRepository() {
    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
        .clientId("client-id")
        .clientSecret("$2a$10$7YV3ms6re4BsJR5e86ETQuWq.2nEWBGnzX8UdTM6wjQ1D7jGcl/wu") // client-secret
        .redirectUri("http://auth-server:8081/login/oauth2/code/client")
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .scope("read")
        .scope("write")
        .scope(OidcScopes.PROFILE)
        .scope("email")
        .scope(OidcScopes.OPENID)
        .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build()).build();

    return new InMemoryRegisteredClientRepository(registeredClient);
  }
}
