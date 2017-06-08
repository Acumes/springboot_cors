package com.htf.controller.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.htf.controller.support.IPersonSupport;
import com.htf.domain.Person;
import com.htf.model.response.PersonRp;
import com.htf.service.IPersonService;
import com.htf.util.PageInfoResult;
import com.htf.util.PageRequest;

@Service
public class PersonSupportImpl implements IPersonSupport {
	
	@Autowired
	private IPersonService personService;
	
//	@Override
//	public PageInfoResult<PersonRp> getPageinfo(PageRequest pageRequest) {
//		Page<Person> expensesPage = personService.getPersonPageInfo(pageRequest);
//		return null;
//	}

}
