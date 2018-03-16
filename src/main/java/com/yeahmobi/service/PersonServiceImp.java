package com.yeahmobi.service;

import com.yeahmobi.rest.Person;
import com.yeahmobi.security.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonServiceImp implements PersonService{

  private final PersonRepository personRepository;

  @Autowired
  public PersonServiceImp(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Page<Person> listAllByPage(Pageable pageable){
    return personRepository.findAll(pageable);
  }

}
