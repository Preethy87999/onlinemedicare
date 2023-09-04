package com.simplilearn.medicare;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

WebDriver driver = null;
	
	By fname = By.id("firstName");
	By lname = By.id("lastName");
	By email = By.id("email");
	By conatctnumber = By.id("contactNumber");
	By password = By.id("password");
	By repassword = By.id("confirmPassword");
	By btnBilling = By.cssSelector("button[name='_eventId_billing']");
	By address1 = By.id("addressLineOne");
	By address2 = By.id("addressLineTwo");
	By city = By.id("city");
	By postalCode = By.id("postalCode");
	By state = By.id("state");
	By country =By.id("country");
	By btnconfirm = By.cssSelector("button[name='_eventId_confirm']");
	
	public  RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendTextForSign(String text,String text2,String text3,String text4, String text5,String text6) {
		driver.findElement(fname).sendKeys(text);
		driver.findElement(lname).sendKeys(text2);
		driver.findElement(email).sendKeys(text3);
		driver.findElement(conatctnumber).sendKeys(text4);
		driver.findElement(password).sendKeys(text5);
		driver.findElement(repassword).sendKeys(text6);	
	}
	
	public void sendTextForSignSupplier(String text,String text2,String text3,String text4, String text5,String text6) {
		driver.findElement(fname).sendKeys(text);
		driver.findElement(lname).sendKeys(text2);
		driver.findElement(email).sendKeys(text3);
		driver.findElement(conatctnumber).sendKeys(text4);
		driver.findElement(password).sendKeys(text5);
		driver.findElement(repassword).sendKeys(text6);	
		driver.findElement(By.id("role2")).click();
	}
	
	public void sendTextForBill(String text,String text2,String text3,String text4, String text5,String text6) {
		driver.findElement(address1).sendKeys(text);
		driver.findElement(address2).sendKeys(text2);
		driver.findElement(city).sendKeys(text3);
		driver.findElement(postalCode).sendKeys(text4);
		driver.findElement(state).sendKeys(text5);
		driver.findElement(country).sendKeys(text6);	
	}
	
	
	public void clickBtnbill() {
		
		driver.findElement(btnBilling).sendKeys(Keys.RETURN);
		driver.findElement(btnconfirm).sendKeys(Keys.RETURN);
	}
	public void clickBtnconfirm() {
		driver.findElement(btnconfirm).sendKeys(Keys.RETURN);
	}
}
