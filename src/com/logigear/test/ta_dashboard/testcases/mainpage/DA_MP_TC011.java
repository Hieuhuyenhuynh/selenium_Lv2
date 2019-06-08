package com.logigear.test.ta_dashboard.testcases.mainpage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.common.Common;

public class DA_MP_TC011 extends BaseTest{
	
	@Test
	public void TC011() {
		
		System.out.println("TC011 - Verify that user is unable open more than 1 \"New Page\" dialog");
		
		//Step 1: Navigate to Dashboard login page
		//Step 2: Login with valid account
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(Common.USERNAME, Common.PASSWORD, Common.REPOSITORY);
		
		//Step 3: Go to Global Setting -> Add page
		homePage.selectItemInvisibleText("Global Settings", "Add Page");
		
		//Step 4: Try to go to Global Setting -> Add page again
		homePage.selectItemInvisibleText("Global Settings", "Add Page");
		
		boolean actual = homePage.isAvailableGlobalSetting("Add Page");
		Assert.assertEquals(actual, false, "Can click on 'Add Page' button");
		
		
	}

}
