package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.element.Element;

public class HomePage extends BasePOM {
	
	// Elements
	protected Element txtRepoName;
	
	public HomePage()
	{
		super(HomePage.class);
	}
	
	@Override
	public void initPageElements()
	{
		this.txtRepoName = new Element(getLocator("txtRepoName").getBy());
	}
	

	public String getRepoName() {
		this.txtRepoName.waitForDisplay();
		return this.txtRepoName.getText();
	}
	

	public HomePage waitForPageDisplay()
	{
		// TODO
		return this;
	}
	
}
