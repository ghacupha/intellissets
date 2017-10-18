/**
 * 
 */
package com.gha.intellissets.intellisets.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gha.intellissets.intellisets.model.Asset;
import com.gha.intellissets.intellisets.model.Role;
import com.gha.intellissets.intellisets.model.User;
import com.gha.intellissets.intellisets.model.repo.AssetRepository;
import com.gha.intellissets.intellisets.model.service.AssetService;
import com.gha.intellissets.intellisets.model.service.security.RoleService;
import com.gha.intellissets.intellisets.model.service.security.UserService;

/**
 * @author edwin.njeru
 *
 */
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AssetService assetService;
	private UserService userService;
	private RoleService roleService;


	private static final Logger log = LoggerFactory.getLogger(SpringJpaBootstrap.class);

	/**
	 * @param assetService the assetService to set
	 */
	@Autowired
	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	/**
	 * @param userService the userService to set
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		loadAssets();
		loadUsers();
		loadRoles();
		assignUsersToUserRole();
		assignUsersToAdminRole();
	}

	private void loadAssets() {

		Asset assetA = new Asset("Table","Head Office","Furniture","12/10/2017",15000.00);
		Asset assetB = new Asset("Chair","Finance","Furniture","12/10/2017",8000.00);
		Asset assetC = new Asset("TV","Treasury","Electronics","12/10/2017",85000.00);

		log.info("saving asset # : {}",assetA.getId());	
		assetService.addAsset(assetA); 
		log.info("saving asset # : {}",assetB.getId());
		assetService.addAsset(assetB);
		log.info("saving asset # : {}",assetC.getId());
		assetService.addAsset(assetC);

	}

	private void loadUsers() {

		User user1 = new User();

		user1.setUserName("user");
		user1.setPassword("user");
		log.info("Updaing user : {}",user1);
		userService.saveOrUpdate(user1);

		User user2 = new User();
		user2.setUserName("admin");
		user2.setPassword("admin");
		log.info("Updaing user : {}",user2);
		userService.saveOrUpdate(user2);
	}

	private void loadRoles() {

		Role role = new Role();
		role.setRole("USER");
		roleService.saveOrUpdate(role);
		log.info("Saved role" + role.getRole());
		Role adminRole = new Role();
		adminRole.setRole("ADMIN");
		roleService.saveOrUpdate(adminRole);
		log.info("Saved role" + adminRole.getRole());
	}
	
	 private void assignUsersToUserRole() {
	        List<Role> roles = (List<Role>) roleService.listAll();
	        List<User> users = (List<User>) userService.listAll();
	 
	        roles.forEach(role -> {
	            if (role.getRole().equalsIgnoreCase("USER")) {
	                users.forEach(user -> {
	                    if (user.getUserName().equals("user")) {
	                        user.addRole(role);
	                        userService.saveOrUpdate(user);
	                    }
	                });
	            }
	        });
	    }
	    private void assignUsersToAdminRole() {
	        List<Role> roles = (List<Role>) roleService.listAll();
	        List<User> users = (List<User>) userService.listAll();
	 
	        roles.forEach(role -> {
	            if (role.getRole().equalsIgnoreCase("ADMIN")) {
	                users.forEach(user -> {
	                    if (user.getUserName().equals("admin")) {
	                        user.addRole(role);
	                        userService.saveOrUpdate(user);
	                    }
	                });
	            }
	        });
	    }
}
