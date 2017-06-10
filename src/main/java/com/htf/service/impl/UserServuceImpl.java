package com.htf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htf.domain.User;
import com.htf.domain.UserInfo;
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
//		return repository.save(user);
		User user = new User();
		user.setStatus(DataStatus.PreActive);
		user.setCode(userInfoRq.getCode());
		
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(userInfoRq.getEmail());
		userInfo.setNickName(userInfoRq.getEmail());
		userInfo.setMobile(userInfoRq.getEmail());
		userInfo.setEnglishName(userInfoRq.getEmail());
		userInfo.setOfficePhone(userInfoRq.getEmail());
		userInfo.setGender(userInfoRq.getEmail());
		user.setUserInfo(userInfo);
		helper.encryptionPassword(user);
		repository.save(user);
		User old = new User();
		String password = "123456";
		old.setSalt(user.getSalt());
		old.setPassword(password);
		helper.encryptionPassword(old);
		System.out.println(old.getPassword().equals(user.getPassword()));
		
		
		
	}

	
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
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
