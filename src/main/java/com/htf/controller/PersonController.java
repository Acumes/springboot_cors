package com.htf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htf.controller.support.IPersonSupport;
import com.htf.domain.Person;
import com.htf.model.request.PersonRq;
import com.htf.model.response.PersonRp;
import com.htf.service.IPersonService;
import com.htf.util.PageInfoResult;
import com.htf.util.PageRequest;

@RestController
@RequestMapping("/person")
public class PersonController {
	//1 Spring Data JPA已自动为你注册bean，所以可自动注入
	@Autowired
	private IPersonService personService;
	
	@Autowired
	private IPersonSupport personSupport;
	
	/**
	 * 保存
	 * save支持批量保存：<S extends T> Iterable<S> save(Iterable<S> entities);
	 * 
	 * 删除：
	 * 删除支持使用id，对象以，批量删除及删除全部：
	 * void delete(ID id);
	 * void delete(T entity);
	 * void delete(Iterable<? extends T> entities);
	 * void deleteAll();
	 * 
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Person save(@RequestBody Person person){
		Person p = personService.save(person);
		
		return p;
		
	}
	

	
	/**
	 * 测试findByAddress
	 */
	@RequestMapping("/q1")
	public List<Person> q1(@RequestParam(value="address",required=false)String address){
		
		List<Person> people = personService.findByAddress(address);
		
		return people;
		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Person> list(){
//		return personSupport.getPageinfo(pageRequest);
		return personService.findAll();
	}
	
	@RequestMapping(value="/save1",method  = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save1(@RequestBody Person person){
//		return personSupport.getPageinfo(pageRequest);
		personService.save(person);
	}
	
	@RequestMapping(value="/{id}",method  = RequestMethod.GET)
	public Person getPersonInfo(@PathVariable String id){
		return personService.findById(Long.parseLong(id));
	}
	
	@RequestMapping(value="/modify",method  = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void modifyPerson(@RequestBody Person person){
		personService.save(person);
	}
	@RequestMapping(value="/dels",method  = RequestMethod.DELETE)
	public void delPerson(@RequestParam String ids){
		personService.delPersons(ids);
	}
	
//	/**
//	 * 测试findByNameAndAddress
//	 */
//	@RequestMapping("/q2")
//	public Person q2(String name,String address){
//		
//		Person people = personService.findByNameAndAddress(name, address);
//		
//		return people;
//		
//	}
//	
//	/**
//	 * 测试withNameAndAddressQuery
//	 */
//	@RequestMapping("/q3")
//	public Person q3(String name,String address){
//		
//		Person p = personService.withNameAndAddressQuery(name, address);
//		
//		return p;
//		
//	}
//	
//	/**
//	 * 测试withNameAndAddressNamedQuery
//	 */
//	@RequestMapping("/q4")
//	public Person q4(String name,String address){
//		
//		Person p = personService.withNameAndAddressNamedQuery(name, address);
//		
//		return p;
//		
//	}
//	
//	/**
//	 * 测试排序
//	 */
//	@RequestMapping("/sort")
//	public List<Person> sort(){
//		
//		List<Person> people = personService.findAll(new Sort(Direction.ASC,"age"));
//		
//		return people;
//		
//	}
//	
//	/**
//	 * 测试分页
//	 */
//	@RequestMapping("/page")
//	public Page<Person> page(){
//		
//		Page<Person> pagePeople = personService.findAll(new PageRequest(1, 2));
//		
//		return pagePeople;
//		
//	}
//	
	
//	@RequestMapping("/auto")
//	public Page<Person> auto(Person person){
//		
//		Page<Person> pagePeople = personService.findByAuto(person, new PageRequest(0, 10));
//		
//		return pagePeople;
//		
//	}
	
	

}
