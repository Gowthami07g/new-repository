package com.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Country;
import com.main.repository.Countrydao;

@SpringBootApplication
@RestController
public class SpringBootApp 
{@Autowired
	Countrydao dao;
	@RequestMapping("/save")
	public String saveCountry(Country country){
		country.setId(20);
		country.setName("India");
		country.setCode("aaa");
		dao.save(country);
		return "saved successfully";
		}
	@RequestMapping("/list")
	public List<Country> countryList()
	{
		List<Country> ls = (List<Country>) dao.findAll();
		return ls;
	}
	@RequestMapping("/fetchById/{id}")
	public List<Country> findById(@PathVariable int id)
	{
		List<Country> ls = (List<Country>) dao.findById(id);
		return ls;
	}
	@RequestMapping("/fetchByName/{name}")
	public List<Country> findByName(@PathVariable String name)
	{
		List<Country> ls = (List<Country>) dao.findByName(name);
		return ls;
	}
	@RequestMapping("/fetchByNameAndId")
	public List<Country> findByNameAndId(@RequestParam String name,@RequestParam int id)
	{
		List<Country> ls = (List<Country>) dao.findByNameAndId(name,id);
		return ls;
	}
	@RequestMapping("/fetchByNameAndCode/{name}/{code}")
	public List<Country> findByNameAndCode(@PathVariable String name,@PathVariable String code)
	{
		List<Country> ls = (List<Country>) dao.findByNameAndCode(name,code);
		return ls;
	}

	
	
     public static void main(String[] args) 
     {
         SpringApplication.run(SpringBootApp.class, args);
     }
} 