package com.lan.example.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SaltedPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		
		// don't encode now.
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		return StringUtils.equals(rawPassword, encodedPassword);
	}

}
