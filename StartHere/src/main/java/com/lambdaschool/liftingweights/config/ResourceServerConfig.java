package com.lambdaschool.liftingweights.config;

import com.lambdaschool.liftingweights.services.CustomTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)
                .stateless(false);
    }

    //@Override
//public void configure(ResourceServerSecurityConfigurer config) {
//    config.tokenServices(tokenServices());
//}
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // http.anonymous().disable();
        http.authorizeRequests()

                .antMatchers("/",
                        "/h2-console/**",
                        "/swagger-resources/**",
                        "/swagger-resource/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/createnewuser").permitAll()
                .antMatchers("/oauth/revoke-token").authenticated()
                //                .antMatchers("/books", "/authors").hasAnyRole("ADMIN", "USER", "DATA") - application data
                //                .antMatchers("/data/**").hasAnyRole("ADMIN", "DATA")
                // .antMatchers("/users/***").hasAnyRole("USER")
                .antMatchers("/roles/**", "/actuator/**").hasAnyRole("ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());

        // http.requiresChannel().anyRequest().requiresSecure();
        http.csrf()
                .disable();
        http.headers()
                .frameOptions()
                .disable();
    }


}
