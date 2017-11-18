package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.ArticleRepository;
import com.sadic.myfastfood.entities.Article;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public List<Article> findAll() {
		return articleRepository.findAll();
	}
	
	@RequestMapping(value="/articles/{id}", method=RequestMethod.GET)
	public Article findOne(@PathVariable Long id) {
		return articleRepository.findOne(id);
	}
	
	@RequestMapping(value="/articles", method=RequestMethod.POST)
	public Article save(@RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	@RequestMapping(value="/articles/{id}", method=RequestMethod.PUT)
	public Article update(@PathVariable Long id, @RequestBody Article article) {
		article.setIdArticle(id);
		return articleRepository.save(article);
	}
	
	@RequestMapping(value="/articles/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			articleRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
