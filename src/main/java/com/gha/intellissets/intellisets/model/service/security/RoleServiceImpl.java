package com.gha.intellissets.intellisets.model.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.gha.intellissets.intellisets.model.Role;
import com.gha.intellissets.intellisets.model.repo.security.RoleRepository;

@Service
@Profile("springdatajpa")
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	/**
	 * @param roleRepository the roleRepository to set
	 */
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<?> listAll() {
		List<Role> roles = new ArrayList<>();
		
		roleRepository.findAll().forEach(roles::add);
		
		return roles;
	}

	@Override
	public Role getById(Integer id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Role saveOrUpdate(Role domainObject) {
		
		return roleRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {

		roleRepository.deleteById(id);
	}
	
	
	
}
