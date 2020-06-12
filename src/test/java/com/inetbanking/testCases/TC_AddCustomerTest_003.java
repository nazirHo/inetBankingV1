package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addCust = new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		logger.info("Providing customer details...........");
		addCust.custName("Isma");
		addCust.custGender("female");
		Thread.sleep(5000);
		addCust.custdob("01","10","2001");
		Thread.sleep(5000);
		addCust.custaddress("usa");
		addCust.custcity("Tela");
		addCust.custstate("pa");
		addCust.custpinno("852753");
		addCust.custtelephoneno("7539518520");
		String email=randomestring()+"@gmail.com";
		addCust.custemailid(email);
		addCust.custpassword("asdfghjkl");
		addCust.custsubmit();
		Thread.sleep(3000);
		logger.info("Validation started.....");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test case passed....");
		}
		else {
			logger.info("Test case failed.....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	

}
