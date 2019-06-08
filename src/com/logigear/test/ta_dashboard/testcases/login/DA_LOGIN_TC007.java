package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC007 extends BaseTest{

	@Test
	public void TC007() {
		System.out.println(
				"TC007 - Verify that \"Username\" is not case sensitive");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		homePage.selectItemFromTopMenu("administrator", "Logout");
		
		USERNAME = "ADMINISTRATOR";
		PASSWORD = "";
		
		homePage = loginPage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String actualMsg = homePage.getRepoName();
		String expectedMsg = "SampleRepository";
		Assert.assertEquals(actualMsg, expectedMsg, "Main page is not displayed.");
		
		
	}
}
