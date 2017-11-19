package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CompteRepository;
import com.sadic.myfastfood.dao.EmployeRepository;
import com.sadic.myfastfood.entities.Employe;

@RestController
public class EmployeController {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	CompteRepository compteRepository;

	@RequestMapping(value="/employes", method=RequestMethod.GET)
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}
	
	@RequestMapping(value="/employes/{id}", method=RequestMethod.GET)
	public Employe findOne(@PathVariable Long id) {
		return employeRepository.findOne(id);
	}
	
	@RequestMapping(value="/employes/{login}", method=RequestMethod.GET)
	public Employe findByCompte(@PathVariable String login) {
		return employeRepository.findByCompte(compteRepository.findByLogin(login));
	}
	
	@RequestMapping(value="/employes", method=RequestMethod.POST)
	public Employe save(@RequestBody Employe employe) {
		return employeRepository.save(employe);
	}
	
	@RequestMapping(value="/employes/{id}", method=RequestMethod.PUT)
	public Employe update(@PathVariable Long id, @RequestBody Employe employe) {
		employe.setIdEmploye(id);
		return employeRepository.save(employe);
	}
	
	@RequestMapping(value="/employes/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			employeRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
