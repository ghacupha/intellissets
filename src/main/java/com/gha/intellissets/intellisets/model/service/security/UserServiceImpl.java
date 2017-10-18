package com.gha.intellissets.intellisets.model.service.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.gha.intellissets.intellisets.model.User;
import com.gha.intellissets.intellisets.model.repo.security.UserRepository;

@Service
@Profile("springdatajpa")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	/**
	 * @param userRepository the userRepository to set
	 */
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	private EncryptionService encryptionService;

	/**
	 * @param encryptionService the encryptionService to set
	 */
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	
	@Override
	public List<?> listAll() {
		List<User> users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);// fun with java 8
		
		return users;
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User saveOrUpdate(User domainObject) {

		if(domainObject.getPassword() != null) {
			domainObject.setEncryptedPassword(
					encryptionService.encryptString(domainObject.getPassword())
					);
		}
		return userRepository.save(domainObject);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String userName) {
		return userRepository.findUserByName(userName);
	}
}
