package org.rf.template.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class untuk dashboard page controller
 */

@Controller
public class DashboardController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(ModelMap map, ModelMap model, HttpSession session) {
		return "test/blank";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap map, ModelMap model, HttpSession session) {
		return "test/login";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formPage(ModelMap map, ModelMap model, HttpSession session) {
		return "test/form";
	}

	@RequestMapping(value = "/test-home", method = RequestMethod.GET)
	public String loginSuccessPage(ModelMap map, ModelMap model,
			HttpSession session) {
		return "test/loginSuccess";
	}
}
