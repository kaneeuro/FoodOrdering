package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
