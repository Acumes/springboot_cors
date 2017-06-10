package com.htf.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.htf.domain.Person;
import com.htf.domain.User;
import com.htf.domain.UserInfo;
import com.htf.model.request.PersonRq;
import com.htf.model.request.UserRq;
import com.htf.model.response.PersonRp;
import com.htf.util.PageInfoResult;
import com.htf.util.PageRequest;

public interface IUserService {
	void save(UserRq user);
//	PageInfoResult<PersonRq> list(PageRequest pageRequest);
//	Page<Person> getPersonPageInfo(PageRequest pageRequest);
	List<User> findAll();
	User findById(Long id);
	void delUsers(String ids);
}
