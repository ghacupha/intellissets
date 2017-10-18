package com.gha.intellissets.intellisets.model.repo.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gha.intellissets.intellisets.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findUserByName(String userName);
}
