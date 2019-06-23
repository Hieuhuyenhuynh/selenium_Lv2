package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class PanelPage extends GeneralPage{

	public PanelPage() {
		super(PanelPage.class);
		// TODO Auto-generated constructor stub
	}
	
	protected Element btnAddNew;
	protected Element btnEdit;
	protected Element btnDelete;
	protected Element btnCheckAll;
	protected AddNewPanelForm addNewPanelForm = new AddNewPanelForm();
	
	public void initPageElements()
	{
		this.btnAddNew = new Element(getLocator("btnAddNew").getBy());
		this.btnCheckAll = new Element(getLocator("btnCheckAll").getBy());
		this.btnDelete = new Element(getLocator("btnDeleteAll").getBy());
	}
	
	public Element getEditByName(String panelName) {
		
		return new Element(getLocator("btnEdit").getBy(panelName));
	}
	
	public PanelPage addNewPanel (String displayName, String series, String chartType) {
		
		btnAddNew.waitForClickable();
		btnAddNew.click();
		
		addNewPanelForm.addNew(displayName, series, chartType);
		return this;
	}
	
	public PanelPage editChartType (String displayName, String chartType) {
		
		getEditByName(displayName).waitForClickable();
		getEditByName(displayName).click();
		
		addNewPanelForm.editChartType(chartType);
		return this;
	}
	
	public void clickOnEditLink (String displayName) {
		
		getEditByName(displayName).waitForClickable();
		getEditByName(displayName).click();
		
	}
	
	public void editChartType(String chartType) {
		
		addNewPanelForm.editChartType(chartType);
	}
	
	public void clickOnCancelBtn() {
		
		addNewPanelForm.clickOnCancelBtn();
	}
	
	public String getChartTypeItem() {
		return addNewPanelForm.getChartTypeText();
	}
	
	public void deleteAll() {
		
		btnCheckAll.waitForClickable();
		btnCheckAll.click();
		
		btnDelete.waitForClickable();
		btnDelete.click();
		
		comfirmChromePopup();
	}
}
