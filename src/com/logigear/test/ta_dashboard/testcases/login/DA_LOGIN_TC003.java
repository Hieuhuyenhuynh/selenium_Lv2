package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC003 extends BaseTest{

	@Test
	public void TC003() {
		System.out.println(
				"TC003 - Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password");
		
		String USERNAME = "administrator";
		String PASSWORD = "abc";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginPage = new LoginPage();
		loginPage = loginPage.loginFailed(USERNAME, PASSWORD, SAMPLE_REPO);

		String actualMsg = loginPage.getMessageOnChromePopup();
		String expectedMsg = "Username or password is invalid";
		Assert.assertEquals(actualMsg, expectedMsg, "The messages are not the same.");
	}
}
