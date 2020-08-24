package com.tony.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Controller
public class QueryController extends Information {

	@RequestMapping(value = "/querySearch")
	public String director() {
		return "QuerySearch";
	}
	
	@RequestMapping(value = "/finalSearch")
	public String specializedQuery(@RequestParam(name = "search")String queryString, Model model) {
		
		ResponseEntity<Bean[]> responseEntity = restTemplate.getForEntity(searchUrl + queryString, Bean[].class);
		Bean[] beans = responseEntity.getBody();
		
		model.addAttribute("myBean", beans);
		
		return "QuerySearch";
	}
	
}
