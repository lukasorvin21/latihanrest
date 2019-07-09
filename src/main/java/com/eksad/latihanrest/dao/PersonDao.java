package com.eksad.latihanrest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.eksad.latihanrest.model.Person;

public interface PersonDao extends PagingAndSortingRepository<Person, Long>
{

}
