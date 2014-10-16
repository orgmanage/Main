package com.orgmanager.web.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.orgmanager.entity.User;
import com.orgmanager.mapper.UserCodeMapper;
import com.orgmanager.mapper.UserMapper;
import com.orgmanager.model.UserModel;
import com.orgmanager.service.UserManagementService;

@Controller
public class UserManagementController {

	@Autowired UserManagementService userService;
	@Autowired UserMapper userMapper;
	@Autowired UserCodeMapper userCodeMapper;

	private static final Logger log = Logger.getLogger(UserManagementController.class);

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String displaySearchPage(ModelMap model){
		final String METHOD_NAME = "displaySearchPage";
		log.info("Method entry " + METHOD_NAME);
		log.info("Method exit " + METHOD_NAME);
		return "search";

	}

	@RequestMapping(value = "/search_user.htm", method = RequestMethod.POST)
	public @ResponseBody
	String searchUsers(ModelMap model, @RequestParam("searchString") String searchString, HttpServletRequest request){
		final String METHOD_NAME = "searchUsers";
		log.info("Method entry " + METHOD_NAME);

		List<UserModel> users = new ArrayList<UserModel>();
		List<User> userList = userService.searchUsers(searchString);
		for (User user : userList) {
			users.add(userMapper.translate(new UserModel(), user));
		}
		String jsonObject = convertObjectToJson(users);
		System.out.println(jsonObject);
		log.info("Method exit " + METHOD_NAME);
		return jsonObject;

	}

	@RequestMapping(value = "/user_details.htm", method = RequestMethod.GET)
	public String getUserDetails(ModelMap model, @RequestParam("userId") Long userId, HttpServletRequest request,
			HttpServletResponse response){
		final String METHOD_NAME = "getUserDetails";
		log.info("Method entry " + METHOD_NAME);
		User user = userService.getUserDetails(userId);
		UserModel userModel = userMapper.translate(new UserModel(), user);
		userCodeMapper.translate(userModel);
		try {
			response.setContentType("image/png");
			OutputStream o = response.getOutputStream();
			o.write(userModel.getUserCode().getUserCode());
			o.flush();
			o.close();

		} catch (Exception ex) {

		}
		log.info("userModel :" + userModel.getUserCode().getByteArrayString());
		model.addAttribute("userModel", userModel);
		log.info("Method exit " + METHOD_NAME);
		return "userDetails";
	}

	@RequestMapping(value = "/create_user.htm", method = RequestMethod.POST)
	public String createUserDetails(@ModelAttribute UserModel userModel, ModelMap model){
		final String METHOD_NAME = "getUserDetails";
		log.info("Method entry " + METHOD_NAME);
		User user = userMapper.translate(userModel);
		User userDetails = userService.createUserDetail(user);
		userMapper.translate(userModel, userDetails);
		userCodeMapper.translate(userModel);
		log.info("userModel :" + userModel.getUserCode().getByteArrayString());
		model.addAttribute("userModel", userModel);
		log.info("Method exit " + METHOD_NAME);
		return "userDetails";
	}

	private String convertObjectToJson(List<UserModel> users){
		JsonArray array = new JsonArray();
		for (UserModel userModel : users) {
			if (null != userModel && null != userModel.getUserId()) {
				array.add(convertUserToJson(userModel));
			}
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		String jsonString = gson.toJson(array);
		return jsonString;
	}

	private JsonObject convertUserToJson(UserModel userModel){
		JsonObject obj = new JsonObject();
		obj.addProperty("label", userModel.getFirstName() + " " + userModel.getLastName());
		obj.addProperty("category", "Users");
		obj.addProperty("value", userModel.getUserId());
		return obj;
	}

}
