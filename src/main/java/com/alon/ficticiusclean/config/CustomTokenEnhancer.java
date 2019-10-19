package com.alon.ficticiusclean.config;

import com.alon.ficticiusclean.model.User;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        accessToken = super.enhance(accessToken, authentication);

        Map<String, Object> additionalInfo = accessToken.getAdditionalInformation();
        
        if (((User) authentication.getPrincipal()).getUsername().contentEquals("paulo"))
            additionalInfo.put("tenant", "alonapi");
        else
            additionalInfo.put("tenant", "outraapi");
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}