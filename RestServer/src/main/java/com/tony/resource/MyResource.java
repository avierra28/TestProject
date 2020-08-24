package com.tony.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tony.dao.UserDAO;
import com.tony.service.UserService;
import com.tony.vo.Bean;

@Path("/v1")
public class MyResource {

	private UserService userService;
	private UserDAO userDAO;

	@PUT
	@Consumes({ MediaType.APPLICATION_XML })
	@Path("/updateUser")
	public void updateUser(Bean bean) {

		userService = new UserService();
		userService.updateUser(bean);

	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML })
	@Path("/addUser")
	public void addUser(Bean bean) {

		userService = new UserService();
		userService.addUser(bean);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUsers")
	public List<Bean> getAllUsers() {

		userDAO = new UserDAO();
		return userDAO.getAll();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUser/{id}")
	public Bean getUser(@PathParam("id") String id) {

		userDAO = new UserDAO();
		return userDAO.getUser(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSpecial/{query}")
	public List<Bean> special(@PathParam("query") String search) {
		userDAO = new UserDAO();
		return userDAO.specializedSearch(search);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/delete/{id}")
	public void deleteUser(@PathParam("id") String id) {

		userService = new UserService();
		userService.deleteUser(id);
	}

}
