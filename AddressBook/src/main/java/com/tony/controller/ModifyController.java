package com.tony.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Controller
public class ModifyController extends Information {
	
	private static String num;

	@RequestMapping(value = "/modifyRecord")
	public String modify() {
		
		return "Modify";
	}
	
	@RequestMapping(value = "/modify1", method = RequestMethod.POST)
	public String modify1(@RequestParam("idNumber") String id, Model model) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		num = id;
		Bean bean = restTemplate.getForObject((viewUrl2 + num), Bean.class);
		model.addAttribute("myBean", bean);
		
		return "Modify";
	}
	
	@RequestMapping(value = "/modify2", method = RequestMethod.POST)
	public String modify2(@ModelAttribute Bean myBean) throws ClassNotFoundException, SQLException {
		
		myBean.setIdString(num);
		restTemplate.put(modifyUrl, myBean);
		
		return "home";
	}
	
}









