package com.uap.it1311l.passwordencryptorapi.webclient;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EncryptionApiClient 
{
    @GetExchange("/encryptstring?secretKey={secretKey}&plainText={plainText}&cryptAlgorithm={cryptAlgorithm}")
    public EncryptionResponse encrypt(@PathVariable String secretKey, @PathVariable String plainText, @PathVariable String cryptAlgorithm);
    
    @GetExchange("/decryptstring?secretKey={secretKey}&encryptedText={encryptedText}&cryptAlgorithm={cryptAlgorithm}")
    public DecryptionResponse decrypt(@PathVariable String secretKey, @PathVariable String encryptedText, @PathVariable String cryptAlgorithm);
}


