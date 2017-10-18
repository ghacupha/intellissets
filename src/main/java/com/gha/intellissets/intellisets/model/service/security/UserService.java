package com.gha.intellissets.intellisets.model.service.security;

import com.gha.intellissets.intellisets.model.User;
import com.gha.intellissets.intellisets.model.service.CRUDService;

public interface UserService extends CRUDService<User> {

	User findByUsername(String userName);
}
