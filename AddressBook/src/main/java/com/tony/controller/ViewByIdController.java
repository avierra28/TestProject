package com.tony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Controller
public class ViewByIdController extends Information {

	private String num;
	
	@RequestMapping(value = "/viewId")
	public String viewId() {
		return "ViewById";
	}
	
	@RequestMapping(value = "/view")
	public String viewRecord(@RequestParam("idNumber") String id, Model model) {
		
		num = id;
		
		Bean responseEntity = restTemplate.getForObject((viewUrl2 + num), Bean.class);
		model.addAttribute("myBean", responseEntity);
		
		return "ViewById";
	}
}
