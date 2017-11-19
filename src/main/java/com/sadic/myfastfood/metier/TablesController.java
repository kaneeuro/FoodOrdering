package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.TablesRepository;
import com.sadic.myfastfood.entities.Tables;

@RestController
public class TablesController {

	@Autowired
	TablesRepository tablesRepository;

	@RequestMapping(value="/tables", method=RequestMethod.GET)
	public List<Tables> findAll() {
		return tablesRepository.findAll();
	}
	
	@RequestMapping(value="/tables/{id}", method=RequestMethod.GET)
	public Tables findOne(@PathVariable Long id) {
		return tablesRepository.findOne(id);
	}
	
	@RequestMapping(value="/tables/{numero}", method=RequestMethod.GET)
	public Tables findByNumero(@PathVariable int numero) {
		return tablesRepository.findByNumero(numero);
	}
	
	@RequestMapping(value="/tables", method=RequestMethod.POST)
	public Tables save(@RequestBody Tables tables) {
		return tablesRepository.save(tables);
	}
	
	@RequestMapping(value="/tables/{id}", method=RequestMethod.PUT)
	public Tables update(@PathVariable Long id, @RequestBody Tables tables) {
		tables.setIdTable(id);
		return tablesRepository.save(tables);
	}
	
	@RequestMapping(value="/tables/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			tablesRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
