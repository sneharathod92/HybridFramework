package com.clc.hybrid.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clc.hybrid.pageobject.LoginPage;
import com.clc.hybrid.utility.XLSUtils;

public class TC_loginDDT_002 extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pwd) throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.setuname(uname);
		logger.info("user name is provided");
		lp.setPwd(pwd);
		logger.info("password name is provided");
		lp.clickLogin();
		Thread.sleep(3000);
		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Thread.sleep(3000);
			logger.warn("login failed");
		}else{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Thread.sleep(3000);
			logger.info("Login test passed");
		}
		
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/clc/hybrid/testdata/HybridData.xlsx";
		int rowNum=XLSUtils.getRowCount(path, "Sheet1");
		int colCount=XLSUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++){
			
			for(int j=0; j<colCount;j++){
				loginData[i-1][j]= XLSUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
