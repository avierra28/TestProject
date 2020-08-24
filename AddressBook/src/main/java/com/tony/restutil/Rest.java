//package com.tony.restutil;
//
//import java.util.ArrayList;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tony.dao.BeanDAO;
//import com.tony.vo.Bean;
//
//@RestController
//@Path("/v1")
//public class Rest {
//	
//	private ArrayList<Bean> beans;
//	
//	//@Autowired
//	//private BeanDAO beanDAO;
//	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	@Path("/getUsers")
//	public ArrayList<Bean> getAllUsers() {
//		BeanDAO beanDAO = new BeanDAO();
//		beans = beanDAO.getAll();
//		
//		return beans;
//	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_XML)
//	@Path("/addUser")
//	public void addUser(Bean bean) {
//		
//		BeanDAO beanDAO = new BeanDAO();
//		beanDAO.addBean(bean);
//		
//	}
//	
//	@PUT
//	@Consumes(MediaType.APPLICATION_XML)
//	@Path("/updateUser")
//	public void updateUser(Bean bean) {
//		
//		BeanDAO beanDAO = new BeanDAO();
//		beanDAO.updateRecord(bean);
//	}
//	
//	@DELETE
//	@Path("/deleteUser/{id}")
//	public void deleteUser(@PathParam("id") String id) {
//		
//		BeanDAO beanDAO = new BeanDAO();
//		beanDAO.restDelete(id);
//		
//	}
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
