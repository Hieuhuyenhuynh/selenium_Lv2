package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC004 extends BaseTest{

	@Test
	public void TC004() {
		System.out.println(
				"TC004 - Verify that user is able to log in different repositories successfully after logging out current repository");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginpage = new LoginPage();
		HomePage homePage = loginpage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		homePage.selectItemFromTopMenu("administrator", "Logout");

		SAMPLE_REPO = "TestRepository";
		loginpage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		
		
		String actualMsg = homePage.getRepoName();
		String expectedMsg = "TestRepository";
		Assert.assertEquals(actualMsg, expectedMsg, "Can login with correct credentials");
	}
}
