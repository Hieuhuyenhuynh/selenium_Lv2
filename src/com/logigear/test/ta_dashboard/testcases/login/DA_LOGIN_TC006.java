package com.logigear.test.ta_dashboard.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class DA_LOGIN_TC006 extends BaseTest{

	@Test
	public void TC006() {
		System.out.println(
				"TC006 - Verify that \"Password\" input is case sensitive");
		
		String USERNAME = "administrator";
		String PASSWORD = "TEST";
		String SAMPLE_REPO = "TestRepository";
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(USERNAME, PASSWORD, SAMPLE_REPO);
		homePage.selectItemFromTopMenu("administrator", "Logout");
		
		USERNAME = "administrator";
		PASSWORD = "test";
		SAMPLE_REPO = "TestRepository";
		
		loginPage = loginPage.loginFailed(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String actualMsg = loginPage.getMessageOnChromePopup();
		String expectedMsg = "Username or password is invalid";
		Assert.assertEquals(actualMsg, expectedMsg, "The messages are not the same.");
		
		
	}
}
