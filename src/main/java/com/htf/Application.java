package com.htf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EntityScan("com.htf.domain")
@EnableJpaRepositories({ "com.htf.repository" })
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }
    
 
}