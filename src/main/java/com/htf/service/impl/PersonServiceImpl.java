package com.htf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htf.domain.Person;
import com.htf.model.request.PersonRq;
import com.htf.model.response.PersonRp;
import com.htf.repository.PersonRepository;
import com.htf.service.IPersonService;
import com.htf.util.PageInfoResult;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private PersonRepository repository;
	
	public List<Person> findByAddress(String address) {
		List<Person> list = repository.findByAddress(address);
		return list;
	}

	public Person save(Person person) {
		return repository.save(person);
	}

	
	public List<Person> findAll() {
		return repository.findAll();
	}

//	 private PageInfoResult convertToPageInfo(Page page){
//	        PageInfoResult<PersonRp> pageInfoResult = new PageInfoResult<PersonRp>();
//	        List<Person> personList = page.getContent();
//	        List<PersonRp> personRpList = new ArrayList<PersonRp>();
//	        if (personList.size() > 0){
//	        	personList.forEach(item -> {
//	                ChargeExpenseRp chargeExpenseRp = new ChargeExpenseRp();
//	                chargeExpenseRp.setTransCode(item.getTransCode());
//	                chargeExpenseRp.setId(item.getId());
//	                chargeExpenseRp.setApprovalTime(item.getApprovalTime());
//	                chargeExpenseRp.setApplicationTime(item.getApplicationTime());
//	                chargeExpenseRp.setStatus(item.getStatus().toString());
//	                chargeExpenseRp.setType(item.getCostType().toString());
//	                chargeExpenseRp.setApplicant(item.getApplicant().getUserInfo().getNickname());
//	                chargeExpenseRp.setAmount(item.getAmount());
//	                if (item.getApprover() != null){
//	                    chargeExpenseRp.setApprover(item.getApprover().getUserInfo().getNickname());
//	                }else{
//	                    chargeExpenseRp.setApprover("暂无");
//	                }
//	                personRpList.add(chargeExpenseRp);
//	            });
//	        }
//	        pageInfoResult.transFromToPageInfoResult(page);
//	        pageInfoResult.setContent(chargeExpenseRpList);
//	        return  pageInfoResult;
//	    }

//	@Override
//	public Page<Person> getPersonPageInfo(com.htf.util.PageRequest pageRequest) {
//		if (pageRequest == null)  pageRequest = new com.htf.util.PageRequest();
//        String keyword = pageRequest.getSearchKeyWord();
//        if (keyword == null)
//            keyword = "";
//        Pageable pageable = new org.springframework.data.domain.PageRequest(pageRequest.getPageNum()-1,pageRequest.getPageSize());
//        Page<Person> expensesPage = repository.findByPage(keyword,pageable);
//        return expensesPage;
//	}


}
