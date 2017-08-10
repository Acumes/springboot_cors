package com.htf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.htf.model.request.UserRq;
import com.htf.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(@RequestBody UserRq userInfo){
		service.save(userInfo);
	}

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		service.deleteUser(id);
	}

	
}
