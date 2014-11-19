package com.lan.example.security;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Slf4j
public class UserService implements UserDetailsService {
	
	private static Map<String, SSUser> userDao = null;
	private static Map<Integer, SSRole> roleDao = null;
	
	static {
		userDao = Maps.newHashMap();
		roleDao = Maps.newHashMap();
		// Add Users
		SSUser u1 = new SSUser();
		u1.setId(1);
		u1.setEnabled(true);
		u1.setPassword("123456");
		u1.setUserName("admin@ss.com");
		
		userDao.put(u1.getUserName(), u1);
		
		SSUser u2 = new SSUser();
		u2.setId(2);
		u2.setEnabled(true);
		u2.setPassword("654321");
		u2.setUserName("user@ss.com");
		
		userDao.put(u2.getUserName(), u2);
		
		// Add Roles
		
		SSRole r1 = new SSRole();
		r1.setId(1);
		r1.setUserId(1); // u1
		r1.setRole("ROLE_ADMIN");
		
		roleDao.put(r1.getUserId(), r1);
		
		SSRole r2 = new SSRole();
		r2.setId(2);
		r2.setUserId(2); // u2
		r2.setRole("ROLE_USER");
		
		roleDao.put(r2.getUserId(), r2);
	};
	

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.debug("try to loadUserByUsername with:" + username);
		SSUser user;
		List<SSRole> roles;
		try {
			user = userDao.get(username);
			if(user == null) {
				throw new UsernameNotFoundException("Username not found");
			}else {
				roles = Arrays.asList(roleDao.get(user.getId()));
			}
		}catch(Exception e) {
			log.error("loadUserByUsername got exception:" + e.getMessage());
			throw new UsernameNotFoundException("Username not found due to:" + e.getMessage());
		}
		
		boolean userNotExpired = true;
		boolean credentialNotExpired = true;
		boolean userNotLocked = true;
		List<SimpleGrantedAuthority> authorities = Lists.transform(roles, new Function<SSRole, SimpleGrantedAuthority>() {

			@Override
			public SimpleGrantedAuthority apply(SSRole role) {
				return new SimpleGrantedAuthority(role.getRole());
			}
			
		});
		UserDetails useDetails = new User(user.getUserName(), user.getPassword(), user.isEnabled(),
				userNotExpired,credentialNotExpired, userNotLocked, authorities);
		return useDetails;
	}
}