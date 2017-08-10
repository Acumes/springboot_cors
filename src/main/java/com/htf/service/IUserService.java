package com.htf.service;

import java.util.List;

import com.htf.domain.User;
import com.htf.model.request.UserRq;

public interface IUserService {
	void save(UserRq user);
//	PageInfoResult<PersonRq> list(PageRequest pageRequest);
//	Page<Person> getPersonPageInfo(PageRequest pageRequest);
	List<User> findAll();
	User findById(String id);
	void delUsers(String ids);

	void deleteUser(String id);
}
