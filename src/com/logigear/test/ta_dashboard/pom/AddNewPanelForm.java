package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class AddNewPanelForm extends GeneralPage {

	public AddNewPanelForm() {
		super(AddNewPanelForm.class);
		// TODO Auto-generated constructor stub
	}

	protected Element cbbSeries;
	protected Element cbbChartType;
	protected Element txtDisplayName;
	protected Element btnOK;
	protected Element btnCancel;
	
	public void initPageElements()
	{
		this.txtDisplayName = new Element(getLocator("txtDisplayName").getBy());
		this.btnOK = new Element(getLocator("btn").getBy("OK"));
		this.btnCancel = new Element(getLocator("btn").getBy("Cancel"));
		this.cbbSeries = new Element(getLocator("cbbSeries").getBy());
		this.cbbChartType = new Element(getLocator("cbbChartType").getBy());
	}
	
	public Element getCbbItemSeries(String itemName) {
		return new Element(getLocator("itemSeries").getBy(itemName));
	}
	
	public Element getCbbItemChartType(String itemName) {
		return new Element(getLocator("itemChartType").getBy(itemName));
	}
	
	public void addNew(String displayName, String series, String chartType) {
		
		txtDisplayName.waitForClickable();
		txtDisplayName.enter(displayName);
		
		cbbSeries.waitForClickable();
		cbbSeries.click();
		
		getCbbItemSeries(series).waitForClickable();
		getCbbItemSeries(series).click();
		
		cbbChartType.waitForClickable();
		cbbChartType.click();
		
		getCbbItemChartType(chartType).waitForClickable();
		getCbbItemChartType(chartType).click();
		
		btnOK.waitForClickable();
		btnOK.click();
	}
	
	public void editChartType(String chartType) {
		
		cbbChartType.waitForClickable();
		cbbChartType.click();
		
		getCbbItemChartType(chartType).waitForClickable();
		getCbbItemChartType(chartType).click();
	}
	
	public void clickOnCancelBtn() {
		
		btnCancel.waitForClickable();
		btnCancel.click();
	}
	
	public String getChartTypeText() {
		return cbbChartType.getValue();
	}
}
