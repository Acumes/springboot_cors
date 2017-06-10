package com.htf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htf.domain.User;
import com.htf.model.RedisModel;
import com.htf.service.impl.RedisServiceImpl;

@Controller
public class TestController {
	@Autowired
	private RedisServiceImpl service;

	// 添加
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public void test() {
		System.out.println("start.....");
		RedisModel m = new RedisModel();
		m.setRedisKey("zhangsanKey01");
		m.setValue("asd");
		User user = new User();
		user.setCode("da");
		m.setObject(user);
		service.put(m.getRedisKey(), m, -1);

		RedisModel m2 = new RedisModel();
		m2.setRedisKey("zhangsanKey02");
		m2.setValue("asd");
		User user1 = new User();
		user1.setCode("da11111");
		m2.setObject(user1);
		service.put(m2.getRedisKey(), m2, -1);

		RedisModel m3 = new RedisModel();
		m3.setRedisKey("zhangsanKey03");
		m3.setValue("asd");
		User user2 = new User();
		user2.setCode("da222222");
		m3.setObject(user2);
		service.put(m3.getRedisKey(), m3, -1);
		RedisModel m4 = service.get(m3.getRedisKey());
		System.out.println(m4);
		System.out.println("add success end..." + service);

		// service.put(u1.getCode(), u1.getCode() + u1.getSalt(), -1);
	}


	// 查询所有对象
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Object getAll() {
		return service.getAll();
	}

	// 查询所有key
	@RequestMapping(value = "/getKeys", method = RequestMethod.GET)
	@ResponseBody
	public Object getKeys() {
		return service.getKeys();
	}

	// 根据key查询
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public Object get() {
		RedisModel m = new RedisModel();
		m.setRedisKey("zhangsanKey02");
		return service.get(m.getRedisKey());
	}

	// 删除
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@ResponseBody
	public void remove() {
		RedisModel m = new RedisModel();
		m.setRedisKey("zhangsanKey01");
		service.remove(m.getRedisKey());
	}

	// 判断key是否存在
	@RequestMapping(value = "/isKeyExists", method = RequestMethod.GET)
	@ResponseBody
	public void isKeyExists() {
		RedisModel m = new RedisModel();
		m.setRedisKey("zhangsanKey01");
		boolean flag = service.isKeyExists(m.getRedisKey());
		System.out.println("zhangsanKey01 是否存在: " + flag);
	}

	// 查询当前缓存的数量
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public Object count() {
		return service.count();
	}

	// 清空所有key
	@RequestMapping(value = "/empty", method = RequestMethod.GET)
	@ResponseBody
	public void empty() {
		service.empty();
	}

}