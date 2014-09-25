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
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(ModelMap model,
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

	@RequestMapping(value = "/authenticate.htm", method = RequestMethod.POST)
	public String authenticate(ModelMap model,
			@ModelAttribute(value = "userModel") UserModel userModel,HttpServletRequest request) {
		final String METHOD_NAME = "authenticate";
		log.info("Method entry " + METHOD_NAME);
		if (null != userModel) {
			if (null == userModel.getCredential().getUserName()) {
				log.error("Invalid userName");
				model.addAttribute("errorMessage", "Invalid userName");
			} else if (null == userModel.getCredential().getPassword()) {
				log.error("Invalid password");
				model.addAttribute("errorMessage", "Invalid password");
			} else if ("Admin".equalsIgnoreCase(userModel.getCredential().getUserName())
					&& "Admin".equalsIgnoreCase(userModel.getCredential().getPassword())) {
				request.getSession().setAttribute("org_user",userModel);
				return "home";
			}
		} else {
			log.error("Invalid Login credentials");
			model.addAttribute("errorMessage", "Invalid Login Credentials");
		}
		log.info("Method exit " + METHOD_NAME);
		return "login";

	}
	
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model,
			@ModelAttribute(value = "userModel") UserModel userModel,
			HttpServletRequest request) {
		final String METHOD_NAME = "logout";
		log.info("Method entry " + METHOD_NAME);
		request.getSession().removeAttribute("org_user");
		log.info("Method exit " + METHOD_NAME);
		return login(model,userModel,request);

	}

}
