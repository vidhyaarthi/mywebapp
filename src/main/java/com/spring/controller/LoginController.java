package com.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("devops") && loginBean.getPassword().equals("devops123")) {
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}


	
	public boolean checkUsername(@ModelAttribute("loginBean") LoginBean loginBean) {
		boolean result =false;
		if (loginBean != null && loginBean.getUserName() != null) {
			String username = loginBean.getUserName();
			if(username.length() == 6)
			{
				result = true;
			}
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	public boolean checkPasswordLength(@ModelAttribute("loginBean") LoginBean loginBean) {
		boolean result =false;
		if (loginBean.getPassword() != null) {
			String password = loginBean.getPassword();
			if(password.length() > 6)
			{
				result = true;
			}
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	public boolean checkPassword(@ModelAttribute("loginBean") LoginBean loginBean) {
		boolean result =false;
		if (loginBean.getPassword() != null) {
			String password = loginBean.getPassword();
			 Pattern p = Pattern.compile( "[0-9]" );
			    Matcher m = p.matcher(password);
			    if(m.find()==true)
			    {
			    	result=true;
			    }
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	public boolean checkNumber(@ModelAttribute("loginBean") LoginBean loginBean) {
		boolean result =false;
		int count=0;
		char ch;
		if (loginBean.getPassword() != null) {
			String password = loginBean.getPassword();
			for(int i=0;i < password.length();i++) {
		        ch = password.charAt(i);
		        if(Character.isUpperCase(ch))
		        {
		        	count++;
		        }
		}
			if(count>0)
			{
				result=true;
			}
		else
		{
			result = false;
		}		
	}
		return result;
}
}