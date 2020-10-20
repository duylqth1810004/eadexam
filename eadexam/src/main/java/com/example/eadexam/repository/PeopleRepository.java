package com.example.eadexam.repository;

import com.example.eadexam.entity.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
}

