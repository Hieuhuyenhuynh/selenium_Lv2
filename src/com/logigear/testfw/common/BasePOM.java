package com.logigear.testfw.common;

import java.util.Map;

import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.conf.Locator;
import com.logigear.testfw.conf.LocatorLoader;
import com.logigear.testfw.conf.TestEnvironmentConfig;
import com.logigear.testfw.driver.BaseDriver;
import com.logigear.testfw.driver.DriverManager;

/**
 * 
 * @author ngocquang.tran
 *
 */
public abstract class BasePOM {
	
	protected BaseDriver webDriver = TestExecutor.getInstance().getCurrentDriver();
	private Map<String, Locator> locators = null;
	
	public BasePOM(Class<?> derivedClass)
	{
		String platform = TestExecutor.getInstance().getEnvironmentConf().getPlatform().toString();
		String target = TestExecutor.getInstance().getEnvironmentConf().getRunTarget().toString();
		// load all locators from JSON file, based on the class-name of the derived class
		locators = LocatorLoader.getLocatorsByClassName(derivedClass, platform, target);
		
		initPageElements();
	}
	
	protected Locator getLocator(String elementName)
	{
		return locators.get(elementName);
	}
	
	public abstract void initPageElements();
	
	public String getMessageOnChromePopup() {
		waitChromePopupAppears();
		return webDriver.switchTo().alert().getText();
	}
	
	public void waitChromePopupAppears() {
		try {
			//logger.printMessage("wait for Chrome Popup Appears");
			int timeWait = 0;
			do {
				
				webDriver.getWindowHandles();
				Thread.sleep(1000);
				timeWait++;
				if (timeWait > 10) {
					break;
				}
			} while (webDriver.getWindowHandles().size() == 0);
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}
}
