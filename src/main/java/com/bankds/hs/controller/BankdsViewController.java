package com.bankds.hs.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@Controller
public class BankdsViewController {

	@RequestMapping(path = "/loginAccess", method = RequestMethod.GET)
	public String viewLoginPage() {
		return "loginAccess";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView safeLandingPage() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("loginAccess");
		} else {
			model.setViewName("bankdsLandingPage");
		}
		return model;
	}

	@RequestMapping(path = "/customerPrediction", method = RequestMethod.GET)
	public ModelAndView customerPrediction() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("loginAccess");
		} else {
			model.setViewName("customerPrediction");
		}
		return model;
	}

	@RequestMapping(path = "/loanPrediction", method = RequestMethod.GET)
	public ModelAndView loanPrediction() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("loginAccess");
		} else {
			model.setViewName("loanPrediction");
		}
		return model;
	}

	@RequestMapping(path = "/accessManagement", method = RequestMethod.GET)
	public ModelAndView accessManagement() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			model.setViewName("loginAccess");
		} else {
			model.setViewName("accessManagement");
		}
		return model;
	}

}
