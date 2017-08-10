package com.htf.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htf.domain.User;
import com.htf.model.DataStatus;
import com.htf.model.request.UserRq;
import com.htf.repository.UserRepository;
import com.htf.service.IUserService;
import com.htf.service.PasswordHelper;

@Service
@Transactional
public class UserServuceImpl implements IUserService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordHelper helper;
	
	public void save(UserRq userInfoRq) {
		User user = new User();
		BeanUtils.copyProperties(userInfoRq,user);
		user.setStatus("1");
		helper.encryptionPassword(user);
		repository.save(user);
	}

	
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String id) {
		return repository.findById(id);
	}

	public void delUserInfos(String ids) {
		String [] iDs = ids.split(",");
		for(String id : iDs){
			repository.deleteById(id);
		}
		
	}

	@Override
	public void delUsers(String ids) {

	}

	@Override
	public void deleteUser(String id) {
		repository.delete(this.findById(id));
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
