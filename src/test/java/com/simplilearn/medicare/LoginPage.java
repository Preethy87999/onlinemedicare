package com.simplilearn.medicare;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver = null;
	By emailenter = By.id("username");
	By passwordenter = By.id("password");
	By btnlogin = By.xpath("//input[@value='Login']");
	
	public  LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void sendTextInLogin(String text,String text2) {
		driver.findElement(emailenter).sendKeys(text);
		driver.findElement(passwordenter).sendKeys(text2);
	}
	
	public void clickBtnLogin() {
		driver.findElement(btnlogin).sendKeys(Keys.RETURN);
	}
}
