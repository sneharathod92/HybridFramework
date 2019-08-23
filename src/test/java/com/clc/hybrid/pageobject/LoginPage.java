package com.clc.hybrid.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;

	public void setuname(String uname) {
		username.sendKeys(uname);

	}

	public void setPwd(String upwd) {
		password.sendKeys(upwd);

	}

	public void clickLogin() {
		login.click();

	}
	
	public void clickLogout() {
		logout.click();

	}
}
