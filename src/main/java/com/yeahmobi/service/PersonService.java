package com.yeahmobi.service;

import com.yeahmobi.rest.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by xixuebin on 2018/3/15.
 */
public interface PersonService {
  Page<Person> listAllByPage(Pageable pageable);
}
