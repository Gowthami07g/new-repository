package com.main.repository;

import java.util.List;

 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.main.model.Country;

public interface Countrydao  extends CrudRepository<Country, Integer>{

	List<Country> findById(int id);

	List<Country> findByName(String name);
	//@Query(value="SELECT c from Country c where c.name=?1 AND c.id=?2")
	@Query(value="SELECT c from Country c where c.name=:name AND c.id=:id")
	List<Country> findByNameAndId(@Param("name")String name,@Param("id") int id);

	List<Country> findByNameAndCode(String name, String code);
	 
	//List<Country> findByNameAndCode(String name, String code);

	
	
	
	
	
}
