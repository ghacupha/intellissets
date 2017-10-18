package com.gha.intellissets.intellisets.model.repo.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gha.intellissets.intellisets.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
