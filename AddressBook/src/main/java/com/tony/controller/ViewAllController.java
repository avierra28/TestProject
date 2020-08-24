package com.tony.controller;

import java.sql.SQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.restutil.Information;
import com.tony.vo.Bean;

@Controller
public class ViewAllController extends Information {

	@RequestMapping(value = "viewAll")
	public String viewAll(Model model) throws ClassNotFoundException, SQLException {


		ResponseEntity<Bean[]> responseEntity = restTemplate.getForEntity(viewUrl1, Bean[].class);
		Bean[] beans = responseEntity.getBody();

		model.addAttribute("myBean", beans);
		return "ViewAllDisplay";
	}

}
