package com.tony.service;

import com.tony.dao.UserDAO;
import com.tony.vo.Bean;

public class UserService {

	private UserDAO userDAO;

	public Bean getUser(String id) {

		userDAO = new UserDAO();
		Bean bean = userDAO.getUser(id);
		return bean;
	}

	public void addUser(Bean bean) {

		userDAO = new UserDAO();
		userDAO.createUser(bean);
	}

	public void updateUser(Bean bean) {

		userDAO = new UserDAO();
		userDAO.updateRecord(bean);

	}

	public void deleteUser(String id) {

		userDAO = new UserDAO();
		userDAO.deleteRecord(id);

	}
}
