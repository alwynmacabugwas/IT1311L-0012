package com.uap.it1311l.passwordencryptorapi.controller;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.UapEncryptionRequest;
import com.uap.it1311l.passwordencryptorapi.service.EncryptDecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptorController 
{

    @Autowired
    EncryptDecryptService encryptDecryptService;
    
    @GetMapping("/api/encryption")
    public EncryptionResponse encryptString(@RequestBody UapEncryptionRequest request) {
        return encryptDecryptService.encrypt(request.getPassword());
    }
    
    @GetMapping("/api/decryption")
    public String decryptString(@RequestBody UapEncryptionRequest request) 
    {
        String encryptedPassword = request.getPassword();
        String decryptedPassword = encryptDecryptService.decrypt(encryptedPassword);

        return decryptedPassword;
    }
}

