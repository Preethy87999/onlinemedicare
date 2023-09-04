package com.simplilearn.medicare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage {

	WebDriver driver = null;
	By btncheckout = By.cssSelector("a.btn.btn-success");
	By addrssspage = By.cssSelector("a[class='btn btn-primary']");
	
	public  CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkoutbtn() {
		driver.findElement(btncheckout).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(addrssspage).click();
	}
	
	
	public void payment() {
		driver.findElement(By.id("cardNumber")).sendKeys("12222");
		driver.findElement(By.id("expityMonth")).sendKeys("08");
		driver.findElement(By.id("expityYear")).sendKeys("23");
		driver.findElement(By.id("cvCode")).sendKeys("xxx");
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-lg.btn-block")).click();
		//Thread.sleep(1000);
	}
	
	public void confirmPayment() throws InterruptedException {
		System.out.println(driver.findElement(By.cssSelector("h3[class='text-center']")).getText());
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a.btn.btn-lg.btn-warning")).click();
	}
}
