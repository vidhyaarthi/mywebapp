package com.spring.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class LoginControllerTest  {
	
	Model model;	
	
	public LoginControllerTest(Model model)
	{
		this.model=model;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Set up has Started");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubmit() {
	
		LoginBean loginBean = new LoginBean();
	LoginController login = new LoginController();
	String result = login.submit(model,loginBean);
	assertEquals("success",result);
		
	}

}
