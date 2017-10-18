package com.gha.intellissets.intellisets.model.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gha.intellissets.intellisets.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserService UserService;

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		UserService = userService;
	}

	private Converter<User, UserDetails> userUserDetailsConverter;
	

	/**
	 * @param userUserDetailsConverter the userUserDetailsConverter to set
	 */
	@Autowired
	@Qualifier(value = "userToUserDetails")
	public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
		this.userUserDetailsConverter = userUserDetailsConverter;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userUserDetailsConverter.convert(UserService.findByUsername(username));
	}

}
