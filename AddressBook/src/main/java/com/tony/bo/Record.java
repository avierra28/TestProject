package com.tony.bo;

import java.sql.SQLException;

import com.tony.vo.Bean;

public interface Record {

	String addRecord(Bean entry) throws ClassNotFoundException, SQLException;

}