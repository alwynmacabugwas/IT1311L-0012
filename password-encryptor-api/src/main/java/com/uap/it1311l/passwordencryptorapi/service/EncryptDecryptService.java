package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.repository.credentialsMybatisRepository;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService 
{
    @Autowired
    EncryptionApiClient encryptionApiClient;
    
    @Autowired
	credentialsMybatisRepository mybatisRepo;
    
    public EncryptionResponse encrypt(String password)
    {
    	EncryptionResponse response = encryptionApiClient.encrypt("sikreto", URLEncoder.encode(password, StandardCharsets.UTF_8), "AES");
		mybatisRepo.insert(response.getResult());
		return response;
    }
    
    public String decrypt(String encryptedPassword) 
    {
        if (mybatisRepo.exists(encryptedPassword) > 0) 
        {
            DecryptionResponse response = encryptionApiClient.decrypt("sikreto", URLDecoder.decode(encryptedPassword,StandardCharsets.UTF_8), "AES");
            return response.getResult();
        } 
        else 
        {
            return "Encrypted Password does not exist.";
        }
    } 
}