package com.app.outh2server.security;

import com.app.outh2server.entity.AuthUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        AuthUserDetails user = (AuthUserDetails) authentication.getPrincipal();
        Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
        if (user.getId() != null)
            info.put("id", user.getId());
        if (user.getUsername() != null)
            info.put("name", user.getUsername());
        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);
        return super.enhance(customAccessToken, authentication);
    }
}

