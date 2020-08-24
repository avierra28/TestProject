package com.tony.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Controller
public class DeleteController extends Information {
	
	private static String num;

	@RequestMapping(value = "/deleteRecord")
	public String delete() {
				
		return "Delete1";
	}
	
	@RequestMapping(value = "/deleteRecord1", method = RequestMethod.POST)
	public String delete1(@RequestParam(name = "number")String id,
			Model model) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		num = id;
		Bean bean = restTemplate.getForObject((viewUrl2 + num), Bean.class);
		model.addAttribute("bean", bean);
		
		return "Delete1";
	}
	
	@RequestMapping(value = "/FinalDelete", method = RequestMethod.POST)
	public String delete2() throws ClassNotFoundException, SQLException {
		
		restTemplate.delete(deleteUrl + num);
		
		return "home";
	}
}
