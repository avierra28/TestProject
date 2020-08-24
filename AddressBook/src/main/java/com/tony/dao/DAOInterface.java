package com.tony.dao;

import java.util.ArrayList;

import com.tony.vo.Bean;

public interface DAOInterface {

	void addBean(Bean bean);

	ArrayList<Bean> getAll();

	Bean retrieveUniqueBean(String id);

	void deleteRecord(Bean bean);

	void updateRecord(Bean bean);

}