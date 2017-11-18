package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.RestaurantRepository;
import com.sadic.myfastfood.entities.Restaurant;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@RequestMapping(value="/restaurants", method=RequestMethod.GET)
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	
	@RequestMapping(value="/restaurants/{id}", method=RequestMethod.GET)
	public Restaurant findOne(@PathVariable Long id) {
		return restaurantRepository.findOne(id);
	}
	
	@RequestMapping(value="/restaurants", method=RequestMethod.POST)
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	@RequestMapping(value="/restaurants/{id}", method=RequestMethod.PUT)
	public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
		restaurant.setIdResto(id);
		return restaurantRepository.save(restaurant);
	}
	
	@RequestMapping(value="/restaurants/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			restaurantRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
