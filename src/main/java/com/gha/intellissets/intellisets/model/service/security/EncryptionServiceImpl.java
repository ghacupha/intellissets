package com.gha.intellissets.intellisets.model.service.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService{

	private StrongPasswordEncryptor strongEncryptor;

	/**
	 * @param strongEncryptor the strongEncryptor to set
	 */
	@Autowired
	public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
		this.strongEncryptor = strongEncryptor;
	}

	@Override
	public String encryptString(String password) {
		return strongEncryptor.encryptPassword(password);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
	}
	
	
}
