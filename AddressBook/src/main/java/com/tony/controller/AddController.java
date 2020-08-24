package com.tony.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tony.bo.RecordBO;
import com.tony.vo.Bean;

@Controller
public class AddController {

	private RecordBO myrecord;
	
	@Autowired
	public AddController(RecordBO recordBO) {
		this.myrecord = recordBO;
	}

	@RequestMapping(value = "/personalAdd")
	public String goToPersonal(@ModelAttribute Bean bean) {
		return "AddRecord";
	}

	@RequestMapping(value = "/personaldo", method = RequestMethod.POST)
	public String addPersonal(Bean bean, Model model) throws ClassNotFoundException, SQLException {
		String errorString = myrecord.addRecord(bean);
		if (errorString.equals("")) {
			return "home";
		} else {
			model.addAttribute("errorMessage", errorString);
			return "AddRecordError";
		}
	}
	
}
