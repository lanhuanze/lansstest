package com.lan.example.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SSRole {
	private int id;
	private int userId;
	private String role;
}
