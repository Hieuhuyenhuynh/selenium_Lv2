package com.logigear.test.ta_dashboard.testcases.panel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.test.ta_dashboard.pom.PanelPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.common.Common;

public class DA_PANEL_TC063 extends BaseTest{
	
	@Test
	public void TC063() {
		
		System.out.println("TC063 - Verify that for \"Action Implementation By Status\" panel instance, when user changes from \"Pie\" chart to any other chart type then change back the \"Edit Panel\" form should be as original			\r\n" + 
				"");
		
		String displayName = "Bee";
		String series = "name";
		String chartType ="Pie";
		
		//Step 1: Navigate to Dashboard login page
		//Step 2: Login with valid account
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginSuccessfully(Common.USERNAME, Common.PASSWORD, Common.REPOSITORY);
		
		//Step 3: Go to Global Setting -> Add page
		homePage.selectItemFromTopMenu("Administer", "Panels");
		
		//Step 4: Try to go to Global Setting -> Add page again
		//homePage.selectItemInvisibleText("Global Settings", "Add Page");
		
		PanelPage panelPage = new PanelPage();
		panelPage = panelPage.addNewPanel(displayName, series, chartType);
		String [] itemChartType = {"Single Bar", "Stacked Bar", "Group Bar", "Line"};
		
		for (int i = 0; i < itemChartType.length; i++) {
			
			panelPage.clickOnEditLink(displayName);
			panelPage.editChartType(itemChartType[i]);
			panelPage.editChartType(chartType);
		
			String actualMsg = panelPage.getChartTypeItem();
			String expectedMsg = "Pie";
			Assert.assertEquals(actualMsg, expectedMsg, "The chart type is not displayed as expected.");
			
			panelPage.clickOnCancelBtn();
		}
		
		
		
	}
	@AfterMethod
	public void postCondition() {
		PanelPage panelPage = new PanelPage();
		panelPage.deleteAll();
	}
}
