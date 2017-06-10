package com.htf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.htf.domain.Person;
import com.htf.domain.User;

public interface UserRepository  extends JpaRepository<User,String> ,JpaSpecificationExecutor<Person>{

	User findById(Long id);

//	void deleteById(long parseLong);

	void deleteById(String id);

//	@Query("select p from person p where p.address like  CONCAT('%',:keyWord,'%') or p.name like CONCAT('%',:keyWord,'%')")
//	Page<Person> findByPage(@Param("keyword")String keyword, Pageable pageable);

}
