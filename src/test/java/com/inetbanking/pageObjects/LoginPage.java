package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin") 
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']") 
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	public void findLogout() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		WebElement flag=ldriver.findElement(By.xpath("//a[text()='Log out']"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		ldriver.switchTo().defaultContent();
				
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	/*public void clickLogout() {
		ldriver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}*/
}
