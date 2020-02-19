package com.app.outh2server.security;

import com.app.outh2server.properties.AuthServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthServerProperties serverProperties;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
//    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//       clients.
        clients.inMemory().withClient(serverProperties.getClientid()).secret(passwordEncoder.encode(serverProperties.getClientSecret())).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(serverProperties.getAccessTokenValidity().intValue())
                .refreshTokenValiditySeconds(serverProperties.getRefreshTokenValidity().intValue());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new CustomTokenEnhancer();
        converter.setSigningKey(serverProperties.getPrivateKey());
        converter.setVerifierKey(serverProperties.getPublicKey());
        return converter;
    }

}

