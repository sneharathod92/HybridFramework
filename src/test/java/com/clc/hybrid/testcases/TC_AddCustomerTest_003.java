package com.clc.hybrid.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clc.hybrid.pageobject.AddCustomerPage;
import com.clc.hybrid.pageobject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addCustomer() throws InterruptedException, IOException{
		
		LoginPage lp=new LoginPage(driver);
		lp.setuname(userN);
		logger.info("user name is provided");
		lp.setPwd(userP);
		logger.info("password name is provided");
		lp.clickLogin();
		
		AddCustomerPage addCusto=new AddCustomerPage(driver);
		addCusto.clickAddNewCustomer();
		logger.info("providing customer details");
		addCusto.txtname("Sneha");
		addCusto.txtgender("f");
		addCusto.txtbirthDate("09", "20", "1992");
		addCusto.txtaddress("Pune");
		addCusto.txtcity("Pune");
		addCusto.txtstate("Maharashtra");
		addCusto.txtpinNo("411052");
		addCusto.txtphoneNum("4563782910");
		String email=randomString()+"@gmail.com";
		addCusto.txtemailId(email);
		addCusto.txtpassword("maya@123");
		addCusto.txtsublimt();
		
		Thread.sleep(3000);
		logger.info("validation started");
		
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true){
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}else{
			captureScreeshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case is failed");
		}
		
		
	}
	 
	

}
