package com.example.SpringPractices.dao;

import com.example.SpringPractices.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {
}
