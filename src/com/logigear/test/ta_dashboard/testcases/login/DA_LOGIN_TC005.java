package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC005 extends BaseTest{

	@Test
	public void TC005() {
		System.out.println(
				"TC005 - Verify that there is no Login dialog when switching between 2 repositories with the same account");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		homePage.selectItemFromTopMenu("Repository: ", "TestRepository");
		
		String actualMsg = homePage.getRepoName();
		String expectedMsg = "TestRepository";
		Assert.assertEquals(actualMsg, expectedMsg, "Can't switch to another repository");
	}
}
