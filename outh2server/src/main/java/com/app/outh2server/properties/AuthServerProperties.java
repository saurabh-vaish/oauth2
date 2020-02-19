package com.app.outh2server.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 19-Feb-20
 */

@Data
@ConfigurationProperties(prefix = "config.oauth2")
public class AuthServerProperties {

    private String clientid;

    private String clientSecret;

    private String privateKey;

    private String publicKey;

    private Long accessTokenValidity;

    private Long refreshTokenValidity;

}
