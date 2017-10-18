package com.gha.intellissets.intellisets.model.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.gha.intellissets.intellisets.model.User;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public UserDetails convert(User user) {
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		
		if(user != null) {
			userDetails.setUserName(user.getUserName());
			userDetails.setPassword(user.getEncryptedPassword());
			userDetails.setEnabled(user.getEnabled());
			
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			
			user.getRoles().forEach(role ->{
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			});
			
			userDetails.setAuthorities(authorities);
		}
		
		return userDetails;
	}

	
}
