package com.orgmanager.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orgmanager.model.UserModel;

@Controller
public class AttendanceManagementController {
	
	
	private static final Logger log = Logger.getLogger(AttendanceManagementController.class);

	@RequestMapping(value = "/generate_id.htm", method = RequestMethod.GET)
	public String generateID(ModelMap model,
			@ModelAttribute(value = "userModel") UserModel userModel,
			HttpServletRequest request) {
		final String METHOD_NAME = "login";
		log.info("Method entry " + METHOD_NAME);

		if (null == userModel)
			userModel = new UserModel();
		String errorMsg = request.getParameter("errorMessage");
		if (null != errorMsg && errorMsg.trim().length() > 0)
			model.addAttribute("errorMessage", errorMsg);

		log.info("Method exit " + METHOD_NAME);
		return "login";

	}

}
