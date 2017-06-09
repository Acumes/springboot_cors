package com.htf.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.htf.domain.Person;

public interface PersonRepository  extends JpaRepository<Person,String> ,JpaSpecificationExecutor<Person>{

	List<Person> findByAddress(String address);

	Person findById(Long id);

	void deleteById(Long id);

//	@Query("select p from person p where p.address like  CONCAT('%',:keyWord,'%') or p.name like CONCAT('%',:keyWord,'%')")
//	Page<Person> findByPage(@Param("keyword")String keyword, Pageable pageable);

}
