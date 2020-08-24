package com.tony.restutil;

import org.springframework.web.client.RestTemplate;

public class Information {
	
	protected static RestTemplate restTemplate = new RestTemplate();
	protected static String addUrl = "http://localhost:8080/RestServer/api/v1/addUser";
	protected static String deleteUrl = "http://localhost:8080/RestServer/api/v1/delete/";
	protected static String viewUrl1 = "http://localhost:8080/RestServer/api/v1/getUsers";
	protected static String viewUrl2 = "http://localhost:8080/RestServer/api/v1/getUser/";
	protected static String modifyUrl = "http://localhost:8080/RestServer/api/v1/updateUser";
	protected static String searchUrl = "http://localhost:8080/RestServer/api/v1/getSpecial/";

	
}
