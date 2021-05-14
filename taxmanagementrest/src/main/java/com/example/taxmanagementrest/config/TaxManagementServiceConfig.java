package com.example.taxmanagementrest.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.context.WebApplicationContext;

/**
 * SECURITY CONFIG -
 * This class contains the security config for keycloak, it also includes a whitelist which using the .permitAll() allows for certain urls to be accessed
 * without authentication, This allows users to access the documentation on swagger!
 *
 * TOGGLE KEYCLOAK-
 * *To turn off keycloak settings allowing user to view localhost:8080 and run unit tests comment out between 1 and 2 and uncomment between 3 and 4!
 * *To turn keycloak back on, uncomment between 1 and 2 and comment between 3 and 4!
 */
@ConditionalOnProperty(value = "keycloak.enabled", matchIfMissing = true)
@Configuration
@EnableWebSecurity
public class TaxManagementServiceConfig extends WebSecurityConfigurerAdapter
{
    /**
     * 1.
     */
    /*String jwkSetUri = "http://localhost:8090/auth/realms/TaxManagementAuthRealm/protocol/openid-connect/certs";

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter()
    {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return jwtAuthenticationConverter;
    }

    @Bean
    JwtDecoder jwtDecoder()
    {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }

    private static final String[] AUTH_WHITELIST = {
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        "/v3/api-docs/**",
        "/swagger-ui/**",
};


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors().and().authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, "/**").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.POST, "/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.PUT, "/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.PATCH, "/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("taxmanagementadmin")
                .anyRequest().authenticated().and().oauth2ResourceServer().jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()));
    }*/
    /**
     * 2.
     */

    /**
     * 3.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.headers().frameOptions().disable();
        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }

    /**
     * 4.
     */

}
