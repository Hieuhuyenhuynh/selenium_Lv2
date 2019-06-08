package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM{

	protected Element cbbParent;
	protected Element cbbItem;
	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initPageElements() {
		// TODO Auto-generated method stub
		
	}
	
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
	
	
	public void selectItemFromTopMenu(String cbbName, String itemName) {
		try {
			this.cbbParent = new Element(getLocator("strMenu").getBy(cbbName));
			this.cbbParent.click();
			
			this.cbbItem = new Element(getLocator("strItem").getBy(itemName));
			this.cbbItem.click();
			
		} catch (Exception e) {
			throw e;
		}
	} 

	
	public void selectItemInvisibleText(String menuTitle, String itemName) {
		try {
			String tmp = "";
			if (menuTitle.equals("Global Settings")) {
				tmp = "mn-setting";
			}
			else if (menuTitle.equals("Choose Panels")) {
				tmp = "mn-panels";
			}
			this.cbbParent = new Element(getLocator("strNonTextMenu").getBy(tmp));
			this.cbbParent.click();
			
			this.cbbItem = new Element(getLocator("strItem").getBy(itemName));
			this.cbbItem.click();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean isAvailableGlobalSetting(String itemName) {
		this.cbbItem = new Element(getLocator("strItem").getBy(itemName));
		return this.cbbItem.isDisplayed(10);
		
	}
}
