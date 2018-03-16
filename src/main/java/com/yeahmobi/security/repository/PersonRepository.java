package com.yeahmobi.security.repository;

import com.yeahmobi.rest.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

  Person findByNameStartsWith(@Param("name")String name);

}
