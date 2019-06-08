package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC008 extends BaseTest{

	@Test
	public void TC008() {
		System.out.println(
				"TC008 - Verify that password with special characters is working correctly");
		
		String USERNAME = "administrator";
		String PASSWORD = "#$%^&";
		String SAMPLE_REPO = "TestRepository";
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String actualMsg = homePage.getRepoName();
		String expectedMsg = "TestRepository";
		Assert.assertEquals(actualMsg, expectedMsg, "Main page is not displayed.");
		
		
	}
}
