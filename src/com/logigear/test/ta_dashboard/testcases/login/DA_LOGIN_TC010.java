package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC010 extends BaseTest{

	@Test
	public void TC010() {
		System.out.println(
				"TC010 - Verify that the page works correctly for the case when no input entered to Password and Username field");
		
		String USERNAME = "";
		String PASSWORD = "";
		String SAMPLE_REPO = "test";
		
		LoginPage loginPage = new LoginPage();
		loginPage = loginPage.loginFailed(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String actualMsg = loginPage.getMessageOnChromePopup();
		String expectedMsg = "Please enter username!";
		Assert.assertEquals(actualMsg, expectedMsg, "The messages are not the same.");
		
		
	}
}
