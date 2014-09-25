package com.orgmanager.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orgmanager.entity.User;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.model.UserModel;
import com.orgmanager.service.UserManagementService;

@Controller
public class UserManagementController {
	
	@Autowired UserManagementService userService;
	
	private static final Logger log = Logger.getLogger(UserManagementController.class);

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String displaySearchPage(ModelMap model) {
		final String METHOD_NAME = "displaySearchPage";
		log.info("Method entry " + METHOD_NAME);
		log.info("Method exit " + METHOD_NAME);
		return "search";

	}
	
	@RequestMapping(value = "/search_user.htm", method = RequestMethod.POST)
	public String searchUsers(ModelMap model, @RequestParam("searchString") String searchString,
			HttpServletRequest request) {
		final String METHOD_NAME = "searchUsers";
		log.info("Method entry " + METHOD_NAME);

		List<UserModel> users= new ArrayList<UserModel>();
		List<User> userList=userService.searchUsers(searchString);
		for (User user : userList) {
			users.add(UserMapper.translate(new UserModel(), user));
		}
		System.out.println(convertObjectToJson(users));
			
		log.info("Method exit " + METHOD_NAME);
		return "search";

	}
	
	private String convertObjectToJson(List<UserModel> users ) {
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			return jsonMapper.writeValueAsString(users);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

}
