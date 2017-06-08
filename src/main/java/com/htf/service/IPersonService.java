package com.htf.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.htf.domain.Person;
import com.htf.model.request.PersonRq;
import com.htf.model.response.PersonRp;
import com.htf.util.PageInfoResult;
import com.htf.util.PageRequest;

public interface IPersonService {
	List<Person> findByAddress(String address);
	Person save(Person person);
//	PageInfoResult<PersonRq> list(PageRequest pageRequest);
//	Page<Person> getPersonPageInfo(PageRequest pageRequest);
	List<Person> findAll();
}
