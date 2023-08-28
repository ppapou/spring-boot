package com.example.data.backendapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "secret")
public class JwtSecretParams {
    String clientId;
    String clientSecret ;
    String privateKey;
    String publicKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public String getPublicKey(){
        return publicKey;
    }

    public String getClientId(){
        return clientId;
    }

    public String getClientSecret(){
        return clientSecret;
    }
}
