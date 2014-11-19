package com.lan.example.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lan on 10/29/14.
*/
 @Controller
 @Slf4j
public class AccountController {
	 @RequestMapping(value = "/admin/v1/userinfo/one/{id}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<String> getAdminInfo(@PathVariable String id) {
		 return new ResponseEntity<String>("Get admin info", HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/user/v1/userinfo/one/{id}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<String> getUserInfo(@PathVariable String id) {
		 return new ResponseEntity<String>("Get user info", HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/other/v1/userinfo/one/{id}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<String> getOtherInfo(@PathVariable String id) {
		 return new ResponseEntity<String>("Get other info", HttpStatus.OK);
	 }
}
