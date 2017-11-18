package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CuisineRepository;
import com.sadic.myfastfood.entities.Cuisine;

@RestController
public class CuisineController {

	@Autowired
	CuisineRepository cuisineRepository;

	@RequestMapping(value="/cuisines", method=RequestMethod.GET)
	public List<Cuisine> findAll() {
		return cuisineRepository.findAll();
	}
	
	@RequestMapping(value="/cuisines/{id}", method=RequestMethod.GET)
	public Cuisine findOne(@PathVariable Long id) {
		return cuisineRepository.findOne(id);
	}
	
	@RequestMapping(value="/cuisines", method=RequestMethod.POST)
	public Cuisine save(@RequestBody Cuisine cuisine) {
		return cuisineRepository.save(cuisine);
	}
	
	@RequestMapping(value="/cuisines/{id}", method=RequestMethod.PUT)
	public Cuisine update(@PathVariable Long id, @RequestBody Cuisine cuisine) {
		cuisine.setIdCuisine(id);
		return cuisineRepository.save(cuisine);
	}
	
	@RequestMapping(value="/cuisines/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			cuisineRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
