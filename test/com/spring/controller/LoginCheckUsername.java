package com.spring.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginCheckUsername {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LoginBean loginBean = new LoginBean();
		LoginController login = new LoginController();
		boolean result = login.checkUsername(loginBean);
		assertEquals(true,result);
	}

}
