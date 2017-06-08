package com.htf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@EntityScan("com.htf.domain")
@EnableJpaRepositories({"com.htf.repository"})
@ComponentScan({"com.htf.controller","com.htf.service","com.htf.util","com.htf.exception","com.htf.model","com.htf.common"})
@EnableTransactionManagement
public class AppConfiguration {
}     
