package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC002 extends BaseTest{

	@Test
	public void TC002() {
		System.out.println(
				"TC002 - Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials");
		
		String USERNAME = "abc";
		String PASSWORD = "abc";
		String SAMPLE_REPO = "TestRepository";
		
		LoginPage loginpage = new LoginPage();
		loginpage = loginpage.loginFailed(USERNAME, PASSWORD, SAMPLE_REPO);

		String actualMsg = loginpage.getMessageOnChromePopup();
		String expectedMsg = "Username or password is invalid";
		Assert.assertEquals(actualMsg, expectedMsg, "The messages are not the same.");
	}
}
