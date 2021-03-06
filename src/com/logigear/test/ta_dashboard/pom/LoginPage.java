package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class LoginPage extends GeneralPage{

	// Elements
	protected Element cbbRepo;
	protected Element txtUsername;
	protected Element txtPassword;
	protected Element btnLogin;
	
	public LoginPage()
	{
		// read configuration of this class via parent class's instructor
		super(LoginPage.class);
	}
	
	@Override
	public void initPageElements()
	{
		this.cbbRepo = new Element(getLocator("cbbRepo").getBy());
		this.txtUsername = new Element(getLocator("txtUsername").getBy());
		this.txtPassword = new Element(getLocator("txtPassword").getBy());
		this.btnLogin = new Element(getLocator("btnLogin").getBy());
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param repo
	 * @return
	 */
	public void login(String username, String password, String repo) {
		cbbRepo.waitForClickable();
		cbbRepo.selectByValue(repo);
		
		txtUsername.waitForClickable();
		txtUsername.enter(username);
		
		txtPassword.waitForClickable();
		txtPassword.enter(password);
		
		btnLogin.waitForClickable();
		btnLogin.click();
	}
	
	public LoginPage loginFailed(String username, String password, String repo) {
		login(username, password, repo);
		return this;
	}
	
	public HomePage loginSuccessfully(String username, String password, String repo) {
		login(username, password, repo);
		return new HomePage().waitForPageDisplay();
	}
	
	/**
	 * 
	 * @param timeOutInSeconds
	 * @return
	 */
	public LoginPage waitForLoading(int timeOutInSeconds) {
		btnLogin.waitForClickable(timeOutInSeconds);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	
	public LoginPage waitForLoading() 
	{
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
}
