package com.htf.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.htf.domain.User;

@Service
public class PasswordHelper {
	
	private RandomNumberGenerator generator = new SecureRandomNumberGenerator();
	
	/**
	 * 加密算法
	 */
	private String algorithmName = "MD5"; 
	/**
	 * 散列次数
	 */
	private int hashIterations = 1024;
	
	/**
	 * 默认密码
	 */
	private String defaultPWD = "123456";

	public RandomNumberGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(RandomNumberGenerator generator) {
		this.generator = generator;
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public String getDefaultPWD() {
		return defaultPWD;
	}

	public void setDefaultPWD(String defaultPWD) {
		this.defaultPWD = defaultPWD;
	}
	
	
	public void encryptionPassword(User user){
		if (null == user.getSalt() || StringUtils.isEmpty(user.getSalt())) {
			user.setSalt(generator.nextBytes().toHex());
		}

		String newPassword = new SimpleHash(algorithmName, user.getPassword() == null ? defaultPWD : user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();

		user.setPassword(newPassword);
		
	}
}
